package com.example.demo.User.DesignMode.YiLaiDaoZhi;

/*
@author  zhaihaibo
@data 2019/12/11 - 20:56
*/
/*
  依赖倒置原则：
  1.把收短信的方法抽取到一个接口中
  2.微信、email、qq等类实现这个接口，并重写发短信的方法
  3.在调用时根据接口的多态性传入对应的类，来实现不同工具的接收短信功能。

 */

public class yilaidaozhi1 {
    public static void main(String[] args) {
        Send send = new Send();
        send.receiveAll(new Email());
        send.receiveAll(new WeiXin());

        Father father = new Son();
        System.out.println("直接输出age其实是父亲额age ----"+father.age);
        int age = ((Son) father).age;
        System.out.println("得到儿子的年龄需要强转成儿子，属性没有多态 -----"+age);
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("say（）是子类重写后的方法");
        father.say();

    }

}


class  WeiXin  implements  Ireceive{

    @Override
    public void receive() {
        System.out.println("接收了微信消息");

    }
}


class Email implements  Ireceive{
    @Override
    public void receive(){
        System.out.println("接收Email信息");
    }
}

class Send{
    public void  receiveAll( Ireceive re){
        re.receive();
    }
}
