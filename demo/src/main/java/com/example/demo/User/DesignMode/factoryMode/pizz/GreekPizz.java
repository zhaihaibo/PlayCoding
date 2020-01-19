package com.example.demo.User.DesignMode.factoryMode.pizz;

/*
@author  zhaihaibo
@data 2019/12/14 - 12:16
*/


public class GreekPizz extends  Pizz {
    @Override
    public void prepare() {
        System.out.println("希腊披萨开始准备原材料");
    }
}
