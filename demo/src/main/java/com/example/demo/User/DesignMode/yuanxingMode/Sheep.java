package com.example.demo.User.DesignMode.yuanxingMode;

/*
@author  zhaihaibo
@data 2019/12/14 - 17:58
*/

//使用原型模式完成克隆羊  -- 必须实现Cloneable接口
public class Sheep implements Cloneable {
    private String name;
    private  int age;

    @Override
    protected Object clone()   {

        Sheep sheep =null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }



    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
