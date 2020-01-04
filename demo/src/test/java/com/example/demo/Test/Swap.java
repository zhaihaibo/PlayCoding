package com.example.demo.Test;

import org.junit.Test;

import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("输入的数字是"+a+"    "+b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("交换后的数字是："+a+"   "+b);
    }


    @Test
    public  void test1(){
        int max = Math.max(5, 10);
        System.out.println(max);
    }

    @Test
    public void test2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String c = scanner.next();

            switch (c) {
                case "+":
                    System.out.println(a + b);
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
                case "*":
                    System.out.println(a * b);
                    break;
                case "\\":
                    System.out.println(a / b);
                    break;
            }
        }
    }
}
