package com.example.demo.User.DesignMode.YiLaiDaoZhi;

/*
@author  zhaihaibo
@data 2019/12/11 - 22:22
*/
public class Son extends  Father {
    int age = 15;

    public Son() {
    }

    public Son(int age) {
        super(age);
    }
    @Override
    public void say(){
        System.out.println("我是儿子！");
    }
}
