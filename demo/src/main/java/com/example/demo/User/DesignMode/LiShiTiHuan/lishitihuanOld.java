package com.example.demo.User.DesignMode.LiShiTiHuan;

/*
@author  zhaihaibo
@data 2019/12/11 - 22:37
*/
/*
    里氏替换原则
    1.在使用继承时，应遵循里氏替换原则，子类尽量不要重写父类的方法
    2.继承会让两个类的耦合性增强，在适当情况下可以使用聚合、组合、依赖来解决问题
 */

public class lishitihuanOld {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("8+3= " +a.add(8,3));

        //由于b可能不小心重写了父类的方法，导致结果与本意不符合
        B b = new B();
        System.out.println("8+3= " +b.add(8,3));
    }

}

class A {
    public  int add(int a ,int b){
        return  a+b;
    }
}

class  B extends  A{
    //在这里我们可能不小心对A的一个加法做了修改
    public int  add(int a ,int b){
        return  a-b;
    }

}