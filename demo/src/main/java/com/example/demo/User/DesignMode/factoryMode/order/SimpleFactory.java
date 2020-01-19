package com.example.demo.User.DesignMode.factoryMode.order;

/*
@author  zhaihaibo
@data 2019/12/14 - 15:17
*/


import com.example.demo.User.DesignMode.factoryMode.pizz.CheesPizz;
import com.example.demo.User.DesignMode.factoryMode.pizz.GreekPizz;
import com.example.demo.User.DesignMode.factoryMode.pizz.Pizz;

/*
    使用简单工厂模式
    1.把新建pizz的任务交给工厂，工厂内部根据业务逻辑生成不同的pizz
    2.OrderPizz和工程聚合，想要pizz时，直接使用工厂创建即可，新加pizz时，只需要改工厂逻辑即可

    工厂模式分三种
    1.简单工厂模式（静态工厂模式）
    2.工厂方法模式
    3.抽象工厂模式

    应用场景：根据不同的条件创建不同的类 例如：Calendar 日历类，可以根据*不同时区*，通过静态工厂创建不同的日历对象
 */
public class SimpleFactory {


    public Pizz creatPizz(String next){
        Pizz pizz = null;
        if (next.equals("cheese")){
            pizz=new CheesPizz();
            pizz.setName("奶酪-披萨");

        }
        else if(next.equals("greek")){
            pizz = new GreekPizz();
            pizz.setName("希腊-披萨");
        }
        return  pizz;
    }

}
