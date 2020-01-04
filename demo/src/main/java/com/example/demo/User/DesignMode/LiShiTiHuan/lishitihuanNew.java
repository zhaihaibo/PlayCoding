package com.example.demo.User.DesignMode.LiShiTiHuan;

/*
@author  zhaihaibo
@data 2019/12/11 - 22:55
*/
/*
    里氏替换原则
    1.在使用继承时，应遵循里氏替换原则，子类尽量不要重写父类的方法
    2.继承会让两个类的耦合性增强，在适当情况下可以使用聚合、组合、依赖来解决问题
    3.要求所有使用基类的地方必须透明的使用其子类对象
 */

public class lishitihuanNew {
    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println("8+3= " +a.add(8,3));

        //在里氏替换思想改进后
        //让每个类都继承一个基类，实现各自的方法，B和A解耦合
        //如果想使用 A 中的方法，把 A 作为变量传进B类，调用即可！
        B1 b = new B1();
        System.out.println("8-3= " +b.div(8,3));
        //使用聚合的方式--调用A中的加法
        System.out.println("使用聚合的方式--调用A中的加法");
        System.out.println("8+3= " + b.juHeA1(8,3));
    }

}

class  Base{

}

class A1  extends  Base{
    public  int add(int a ,int b){
        return  a+b;
    }
}

class  B1 extends  Base{

    //使用聚合的方式调用A1中的方法
    private  A1 a1= new A1();

    public int juHeA1(int a ,int b){
        return  this.a1.add(a,b);
    }

    public int  div(int a ,int b){
        return  a-b;
    }



}