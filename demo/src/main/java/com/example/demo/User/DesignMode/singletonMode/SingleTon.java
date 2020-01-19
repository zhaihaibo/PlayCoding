package com.example.demo.User.DesignMode.singletonMode;

/*
@author  zhaihaibo
@data 2019/12/13 - 15:26

单例模式： 饿汉式    在类加载的时候就进行了实例化，避免了线程同步问题 缺点：可能浪费空间
1.私有化构造器
2.在类内部创建对象实例
3.公共方法返回对象实例
*/


public class SingleTon {
    public static void main(String[] args) {

        // 1.饿汉式： 为true代表两个对象是同一个，
        Single instance = Single.getInstance();
        Single instance1 = Single.getInstance();
        System.out.println(instance == instance1); //true


        //2.懒汉式  但是线程不安全，原因：多个线程同时进入if判断，就会创建多个对象，所以只适用于单线程
        //如何保证线程安全 ： 加锁synchronized  ，但是效率低！ 不推荐
        LazySingle instance2 = LazySingle.getInstance();
        LazySingle instance3 = LazySingle.getInstance();
        System.out.println(instance2 == instance3);

        //3.双重检查模式


        //4.使用静态内部类 （推荐使用）


        //5.枚举（极力推荐，在EmnuSingele中实现）

    }


}

//饿汉式
class Single {

    int a = 10;

    private Single(int a) {
        this.a = a;
    }

    private static Single single = new Single(20);

    public static Single getInstance() {
        return single;
    }
}

//懒汉式
// 但是线程不安全，原因：多个线程同时进入if判断，就会创建多个对象，所以只适用于单线程
//如何保证线程安全 ： 加锁synchronized  ，但是效率低！ 不推荐
class LazySingle {

    private LazySingle() {
    }

    private static LazySingle lazySingle = null;

    public static synchronized LazySingle getInstance() {
        if (lazySingle != null) {
            lazySingle = new LazySingle();
        } else {
            return lazySingle;
        }
        return null;
    }
}

//双重检查
//解决了懒汉和饿汉同时存在的问题
class SingleDouble {

    private static SingleDouble singleDouble = null;

    private SingleDouble() {
    }

    public SingleDouble getInstance() {
        if (singleDouble == null) {
            synchronized (SingleDouble.class) {
                //第二层判断
                if (singleDouble == null) {
                    singleDouble = new SingleDouble();
                }
            }
        }
        return singleDouble;
    }


}


//静态内部类
class  StaticSingle{

    private  StaticSingle(){}

    //使用静态内部类的好处
    /*
        1.在StaticSingle主类加载时，静态内部类并不会也跟着加载，而是在调用时才加载，保证了懒加载
        2.jvm在加载的时候是线程安全的，就保证了线程安全问题
     */
    private static class singletonInstance{

        private  static  final  StaticSingle INSTANCE = new  StaticSingle();
    }

    public static  synchronized  StaticSingle getInstance1(){
        return  singletonInstance.INSTANCE;
    }

}