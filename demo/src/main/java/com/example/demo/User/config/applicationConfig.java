package com.example.demo.User.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "config")
public class applicationConfig {

    //使用ConfigurationProperties获取配置文件多级目录
    //1.只有两级目录时：直接定义成属性即可
    //2.当有两级以上目录时，需要从第二级开始，把目录做成类，二级以下的目录皆以内部类的形式呈现，直到最后一级目录同样定义成属性。

    private String secret; //第一个


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    private authClass auth = new authClass(); //第二个

    public authClass getAuth() {
        return auth;
    }

    public void setAuth(authClass auth) {
        this.auth = auth;
    }

    public class authClass {
        private passwordClass password = new passwordClass();

        public passwordClass getPassword() {
            return password;
        }

        public void setPassword(passwordClass password) {
            this.password = password;
        }


    }

    public static class passwordClass {
        private int length = 1;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }
}
