package com.example.demo.User.NiuKeWang;

/*
@author  zhaihaibo
@data 2019/12/9 - 22:55
*/
public class maopao {
    public static void main(String[] args) {

        int [] m = new int[]{5,8,6,1,999};
        for (int i = 0 ;i<m.length-1;i++){
            for (int j =0; j<m.length-1-i;j++){
                if (m[j]>m[j+1]) {
                    int temp = m[j + 1];
                    m[j + 1] = m[j];
                    m[j] = temp;
                }
            }
        }
        for (int i : m) {
            System.out.print(i+" ");
        }
        System.out.println("---------------");

        //注意不能使用数组的aslist集合使用迭代器遍历，因为aslist底层的ArrayList是一个Arrays的内部类，就没有迭代器这个方法
//        List list = Arrays.asList(m);
//        Iterator it = list.iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }


    }
}
