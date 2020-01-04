package com.example.demo.User;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties
public class Configuration {

    private final Logger log = LoggerFactory.getLogger(Configuration.class);


    //创建user
    @Bean(initMethod = "init" ,destroyMethod = "destory")
    public User addUser( ){

        log.error("我是user，被注入到了容器中+----------------------");
        return  new User();
    }


   //加载redis连接池属性   因为本地并未配置redis集群，在这里取消@Bean，先不向容器中注入
   // @Bean
    @ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
    public GenericObjectPoolConfig genericObjectPoolConfig( ){

        //这个类不是线程安全的，他只是用来提供创建池时使用的属性 （就是把配置文件的redis池的配置加载）
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        int minIdle = genericObjectPoolConfig.getMinIdle();
        int maxIdle = genericObjectPoolConfig.getMaxIdle();
        int maxTotal = genericObjectPoolConfig.getMaxTotal();
        genericObjectPoolConfig.setTestOnBorrow(true);

        System.out.println(minIdle+"\t\t"+maxIdle+"\t\t"+maxTotal+"\t\t");

        log.error("我是GenericObjectPoolConfig，配置文件的redis池的配置加载完成----------------------------");
        return  genericObjectPoolConfig;
    }

    //redis集群配置   RedisProperties这个类已经帮我们加载了配置文件的配置（集群节点、最大连接数之类）
   // @Bean
    public RedisClusterConfiguration redisClusterConfiguration(RedisProperties redisProperties){
        RedisClusterConfiguration redisClusterConfiguration
                = new RedisClusterConfiguration(redisProperties.getCluster().getNodes());
        redisClusterConfiguration.setMaxRedirects(redisProperties.getCluster().getMaxRedirects());
        log.error("redis集群节点//////最大连接数配置成功 ------------------------------");
        return  redisClusterConfiguration;
    }


    //redis连接工厂，他里边装了结合了redis集群配置，和LettucePoolingClientConfiguration连接池的配置
  //  @Bean
    public RedisConnectionFactory redisConnectionFactory(RedisClusterConfiguration redisClusterConfiguration){

        LettuceClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(15))
                .shutdownTimeout(Duration.ZERO)
                .poolConfig(genericObjectPoolConfig() )
                .build();

        log.error("redis连接工厂已创建成功- - - -  -- - - -- - - -- - --  -- - -- ");
        return  new LettuceConnectionFactory(redisClusterConfiguration,clientConfig);
    }


    /**
     * 解决redisTemplate 使用默认jdk的序列号导致redis key-value 编码异常问题
     * @param redisConnectionFactory
     * @return
     */
   // @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //设置value的序列化规则和 key的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

  //  @Bean
  //  @Qualifier
    public KeyGenerator wiselyKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                // sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

  //  @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        Jackson2JsonRedisSerializer<?> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisSerializationContext.SerializationPair<?> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jackson2JsonRedisSerializer);
        RedisCacheConfiguration cacheCfg = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair)
                .entryTtl(Duration.ofSeconds(600));
        // return RedisCacheManager.create(connectionFactory);
        return new RedisCacheManager(redisCacheWriter, cacheCfg);
    }

}
