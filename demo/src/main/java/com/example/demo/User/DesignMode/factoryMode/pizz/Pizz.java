package com.example.demo.User.DesignMode.factoryMode.pizz;

/*
@author  zhaihaibo
@data 2019/12/14 - 12:07

完成一个pizz的订购项目
1.披萨的种类有很多（奶酪披萨cheese  希腊披萨Greek ）
2.披萨的制作过程有 prepare , bake , cut , box
3.完成披萨的订购功能
*/


/*
1.做一个抽象类，让所有的不同的pizz类继承
2.制作步骤是每个pizz类都有的，不用写成抽象的，设置不同的name即可
 */
public abstract class Pizz {
    protected  String name;

    public abstract void prepare();

    public void bake(){
        System.out.println(name+" 开始烘烤！");
    }

    public void cut(){
        System.out.println(name+" 开始切块！");
    }

    public void box(){
        System.out.println(name+" 开始打包！");
    }

    public void  setName( String name){
        this.name = name;
    }
}
