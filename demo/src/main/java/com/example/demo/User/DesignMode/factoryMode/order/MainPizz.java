package com.example.demo.User.DesignMode.factoryMode.order;

import com.example.demo.User.DesignMode.factoryMode.pizz.Pizz;

/*
@author  zhaihaibo
@data 2019/12/14 - 12:26
*/
public class MainPizz {
    public static void main(String[] args) {
//        OrderPizz orderPizz = new OrderPizz();
//        Pizz pizz = orderPizz.orderOnePizz();
        OrderPizz orderPizz = new OrderPizz();
        Pizz pizz = orderPizz.factoryPizz();
    }
}
