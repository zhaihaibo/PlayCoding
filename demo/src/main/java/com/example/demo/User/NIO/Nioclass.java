package com.example.demo.User.NIO;


import java.nio.ByteBuffer;

public class Nioclass {

    public static void main(String[] args) {

        ByteBuffer buf = ByteBuffer.allocate(1024);
        String s = "abcde";
        buf.put(s.getBytes());
        System.out.println(buf.capacity()+"-------");
        System.out.println(buf.limit()+"-------");
        System.out.println(buf.position()+"-------");


        buf.flip(); //转换读数据模式
        System.out.println(buf.capacity()+"-------");
        System.out.println(buf.limit()+"-------");
        System.out.println(buf.position()+"-------");

        byte [] b =new byte[buf.limit()]; //创建一个和limit一样长的数组
        buf.get(b); //取数据到数组b中
        System.out.println(new String(b,0,1));
        System.out.println(buf.capacity()+"-------");
        System.out.println(buf.limit()+"-------");
        System.out.println(buf.position()+"-------");



    }




}
