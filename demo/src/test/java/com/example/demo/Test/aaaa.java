package com.example.demo.Test;

import java.util.Scanner;

public class aaaa {
    public static void main(String[] args) {

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
                default:
                    break;
            }
        }
    }
}

