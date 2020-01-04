package com.example.demo.User.DesignMode.singletonMode;

/*
@author  zhaihaibo
@data 2019/12/14 - 11:33
*/


public class EmnuSingleton {

    public static void main(String[] args) {
        //枚举类创建的单例，==为true
        singleton3 instance = singleton3.INSTANCE;
        singleton3 instance1 = singleton3.INSTANCE;
        System.out.println(instance==instance1);

        //调用枚举类中的方法
        instance.sayok();

    }
}

//利用枚举实现单例（十分常用）
enum singleton3{
    INSTANCE;
    public void sayok(){
        System.out.println("利用枚举创建单例，公司经常用！");
    }
}