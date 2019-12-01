package com.example.demo.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("4");

//        String str="six";
//        str=String.format("Hi,%s", "小超");
//        System.out.println(str);
//        str=String.format("Hi,%s %s %s", "小超","是个","大帅哥");
//        str=String.format()
//        System.out.println(str);


        System.out.println(list+"++++++++");

        list.removeIf(l->l.equals("1"));
        System.out.println(list+"使用java8的removeIf（）");


      for (int i = 0 ;i <list.size();i++){
           if (list.get(i).equals("4")){
               list.remove(i);
           }
      }

        System.out.println(list+"for循环！");


        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if (next.equals("5")){
                iterator.remove();
            }
        }
        System.out.println(list+"迭代器");


//删除数组中指定的元素
        int[] arr = new int[]{1,2,4,5,9,8,0};

//        List<int[]> ints = Arrays.asList(arr);
//        ints.remove(0);  //会出异常
//        System.out.println(ints);
        System.out.println(Arrays.toString(arr) +"--------77777");
        //指定删除数组中第三个元素  4
        // 思路：1.用最后一个元素替代要删除的元素
        //      2.把原来的数组缩容
        //替换
        arr[2]=arr[arr.length-1];
        //缩容
        int[] arr1 = Arrays.copyOf(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr1) +"??????????");


//        for (int i = 0 ; i<list.size();i++){
//            if (list.get(i).equals("5")){
//                list.re
//            }
//        }
        System.out.println(list+"---------");

//        Object[] objects = list.toArray();
//        System.out.println(objects);
//        list.remove(1-1);
//        System.out.println(list+"--------------");


    }
}
