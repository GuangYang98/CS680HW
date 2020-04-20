package edu.umb.cs680.hw02;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Calculator cut = new Calculator();
        Scanner sc = new Scanner(System.in);
        float x = sc.nextFloat();
        float y = sc.nextFloat();
        System.out.println(cut.multiply(x, y));
//        System.out.println(cut.divide(x, y));
    }
}
