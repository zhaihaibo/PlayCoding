package com.example.demo.User.DesignMode.factoryMode.pizz;

/*
@author  zhaihaibo
@data 2019/12/14 - 12:16
*/
public class CheesPizz  extends  Pizz{
    @Override
    public void prepare() {
        System.out.println("奶酪披萨开始准备原材料");
    }
}
