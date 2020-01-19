package com.example.demo.User.DesignMode.factoryMode.order;

import com.example.demo.User.DesignMode.factoryMode.pizz.Pizz;

import java.util.Scanner;

/*
@author  zhaihaibo
@data 2019/12/14 - 12:17
*/
public class OrderPizz {

    public OrderPizz() {
    }

    //注意：这种模式违反了ocp原则（对修改关闭，对扩展开放） ，当我们新加一个pizz时，需要修改这里的业务逻辑
//    public Pizz orderOnePizz( ){
//        Pizz pizz = null;
//        do {
//            System.out.println("------------------------------------");
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入需要定制的pizz的名字：");
//            String next = scanner.next();
//            if (next.equals("cheese")){
//                pizz=new CheesPizz();
//                pizz.setName("奶酪-披萨");
//
//            }
//            else if(next.equals("greek")){
//                pizz = new GreekPizz();
//                pizz.setName("希腊-披萨");
//            }else {
//                System.out.println("不好意思，本店没有你输入的披萨名字");
//                break;
//            }
//            pizz.prepare();
//            pizz.bake();
//            pizz.cut();
//            pizz.box();
//        }while (true);
//        return  pizz;


    private SimpleFactory simpleFactory = new SimpleFactory();

    public Pizz factoryPizz() {
        Pizz pizz =null;
        do {
            System.out.println("--------------使用简单工厂创建Pizz-----------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入需要定制的pizz的名字：");
            String next = scanner.next();
            pizz = simpleFactory.creatPizz(next);
            if (pizz!=null){
                pizz.prepare();
                pizz.bake();
                pizz.cut();
                pizz.box();
            }else {
                System.out.println("不好意思，本店没有你输入的披萨名字");
                break;
            }


        }while (true);

      return pizz;
    }

}

