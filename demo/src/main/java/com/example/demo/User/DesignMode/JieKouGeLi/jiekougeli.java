package com.example.demo.User.DesignMode.JieKouGeLi;

/*
@author  zhaihaibo
@data 2019/12/11 - 17:06
*/
//接口隔离原则：
// 进行接口拆分，类中尽量实现自己需要的接口，通过实现多个接口的方式来执行
// A类只需要B类中的op1、op2、op3的方法，B类只需实现接口1 2即可
public class jiekougeli {
    public static void main(String[] args) {
        A a = new A();
        a.dept1(new B());  //利用接口的多态性，在A类中实现B类中的方法
        a.dept2(new B());
        a.dept3(new D());

    }
}


interface  interface1{
    void op1();
}
interface  interface2{
    void op2();
    void op3();
}
interface  interface3{
    void op4();
    void op5();
}
class A{
    public  void dept1(interface1 in){
        in.op1();
    }
    public void dept2(interface2 in){
        in.op2();
    }
    public void dept3(interface3 in){
        in.op4();
    }
}

class  B implements  interface1,interface2{

    @Override
    public void op1() {
        System.out.println("B类直行 op1 操作++++");
    }

    @Override
    public void op2() {
        System.out.println("B类直行 op2 操作++++");
    }

    @Override
    public void op3() {
        System.out.println("B类直行 op3 操作++++");
    }
}


class  D implements  interface1,interface3{

    @Override
    public void op1() {
        System.out.println("B类直行 op1 操作++++");
    }

    @Override
    public void op4() {
        System.out.println("B类直行 op4 操作++++");
    }

    @Override
    public void op5() {
        System.out.println("B类直行 op5 操作++++");
    }
}