package com.example.demo.User.NiuKeWang;

import java.util.Scanner;

/*
@author  zhaihaibo
@data 2019/12/9 - 23:18
*/

//求n的阶乘相加    例如 ： s！-（s-1）！+（s-2）!+...+1!
//  第一种：在while中定义
public class JieCheng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字，得到他的阶乘!");
        while (true) {
            int i = scanner.nextInt();
          //  System.out.println("---"+mod(i));
            int m = 0;
            for (int j = i ; j>0 ; j--){
                int mod = mod(j);
                m+=mod;
            }
            System.out.println(m);

        }
    }
    //mod方法取 s的阶乘    例如 ：s！
    public static int mod(int s ){
        if (s == 0){
            return  0;
        }
        if (s == 1){
            return  1;
        }
        //递归算法
        if (s > 1){
            return  s*mod(s-1);
        }
        return  0;
    }

    //add方法取 s的阶乘   例如 ： s！-（s-1）！+（s-2）!+...+1!
    public static int add(int s ){
        if (s == 0){
            return  0;
        }
        if (s == 1){
            return  1;
        }
        if (s > 1){

        }
        return  0;
    }
}
