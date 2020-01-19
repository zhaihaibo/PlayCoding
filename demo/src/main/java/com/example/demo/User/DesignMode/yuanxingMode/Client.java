package com.example.demo.User.DesignMode.yuanxingMode;

/*
@author  zhaihaibo
@data 2019/12/14 - 18:03
*/
public class Client {
    public static void main(String[] args) {
        //使用传统模式克隆羊
        Sheep sheep = new Sheep("tom", 12);
        Object clone1 = sheep.clone();
        Object clone2 = sheep.clone();
        Object clone3 = sheep.clone();
        Object clone4 = sheep.clone();
        Object clone5 = sheep.clone();
        System.out.println("clone1= " + clone1);
        System.out.println("clone2= " + clone2);
        System.out.println("clone3= " + clone3);

        //还可以使用流的形式 序列化和反序列化
        //把当前对象以对象流的形式输出-->再以对象的形式输入
        //重写要深拷贝的类的clone方法即可
    }
}
