package com.example.demo.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//@Component
public class ApplicationListenerTest2 implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger log = LoggerFactory.getLogger(ApplicationListenerTest2.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {



        log.info("spring容器加载完成后，执行监听器的ContextRefreshedEvent事件操作---------------------------");

        //容器加载完成后，通过ContextRefreshedEvent事件获取容器，并遍历容器中指定的注解的bean
        String[] beanNamesForAnnotation = event.getApplicationContext().getBeanNamesForAnnotation(Controller.class);
        log.info("获取所有带有Controller注解的bean的name//////////////////////");
        for (String s : beanNamesForAnnotation) {
            log.info(s+"//////////////////////////////");
        }

        //容器加载完成后，通过ContextRefreshedEvent事件获取容器，并遍历容器中指定的注解的bean的name
        Map<String, Object> controllers = event.getApplicationContext().getBeansWithAnnotation(Controller.class);
        Set<Map.Entry<String, Object>> entries = controllers.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        log.info("获取所有带有Controller注解的bean的map对象 （key - name  ********  value - 对象地址）");
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            log.info(next.getKey()+"**********************************"+next.getValue());
        }

        boolean userController = event.getApplicationContext().containsBean("userController");
        boolean userController1 = event.getApplicationContext().containsBeanDefinition("userController");
        boolean userController2 = event.getApplicationContext().containsLocalBean("userController");
        int beanDefinitionCount = event.getApplicationContext().getBeanDefinitionCount();
        String[] beanNamesForType = event.getApplicationContext().getBeanNamesForType(UserController.class);
        String property = event.getApplicationContext().getEnvironment().getProperty("server.port");
        Controller annotationOnBean = event.getApplicationContext().findAnnotationOnBean("userController",Controller.class);

        //从容器中获取bean对象，第一种
        User user1 = event.getApplicationContext().getBean(User.class);
       // Object user3 = event.getApplicationContext().getBean("User");
        System.out.println(user1);
        System.out.println(user1.getName());

        //从容器中获取bean对象，这时会报错，因为redis集群配置是在配置文件进行配置，他不能加载配置文件的东西
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
//        User user2 = context.getBean(User.class);
//        System.out.println(user2);
//        System.out.println(user2.getName());

//        redisTemplate.opsForValue().set("123",456,60L, TimeUnit.SECONDS);
        log.info("监听器在所有对象加入容器之后在redis集群中添加了值 -----------------------"+redisTemplate.opsForValue().get("123"));

    }
}
