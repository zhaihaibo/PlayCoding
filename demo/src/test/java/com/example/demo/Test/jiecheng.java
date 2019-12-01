package com.example.demo.Test;


//求15！+14！+13！+...+1!的结果

//阶乘算法
public class jiecheng {
    public static void main(String[] args) {
        jiecheng jiecheng = new jiecheng();
        Integer add = jiecheng.add(15);
        System.out.println(add);
    }

    public Integer mod(int a){
        int sum=0 ;
        if (a<=1){
            return a;
        }
        sum = a * mod(a-1);
        return  sum;
    }
    public Integer add(int a ){
        int b = 0;
        for (int i = a ; a>=1;a--){
            b+=mod(a);
            System.out.println(b+"----------");
        }

        return b;
    }
}
