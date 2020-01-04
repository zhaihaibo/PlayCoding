package com.example.demo.Test;

public class InnerClass {
    public static void main(String[] args) {

        A a = new A();
        a.m();

    }

}

class A {

    int a = 30;


    public void m() {
       final int age = 40;
        //局部内部类
        class Inner {
             final  int a = 90;

            public void print() {
                int a = 70;
                System.out.println(a);
                System.out.println(this.a);
                System.out.println(A.this.a);


                //System.out.println(A.this.m());
            }
        }
        new Inner().print();
    }
}

