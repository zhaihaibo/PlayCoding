package com.example.demo.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射
public class ReflectTest {
    public static void main(String[] args) {

        //反射获取Class对象的四种方式
        //第一种
        Class<User> clazz = User.class;
        //第二种
        User user = new User();
        Class<? extends User> aClass = user.getClass();

        //第三种
        try {
            Class<?> aClass1 = Class.forName("com.example.demo.Test.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //第四种
        try {
            Class<?> aClass1 = ReflectTest.class.getClassLoader().loadClass("com.example.demo.Test.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //通过反射获取类私有的方法

        try {
            User user1 = clazz.newInstance();
            Method declaredMethod = clazz.getDeclaredMethod("say", String.class,Integer.class);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println(parameterType.getName());
                }
                //System.out.println(method.getParameterTypes());
                System.out.println(method.getName());
            }
            System.out.println("++++++++++++++++++++");
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField.getName());
                System.out.println(declaredField.getGenericType());
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(user1,"nihao");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
