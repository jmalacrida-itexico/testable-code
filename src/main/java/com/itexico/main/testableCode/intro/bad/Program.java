package com.itexico.main.testableCode.intro.bad;

public class Program {

    public static void main(String... args) {
        Float parts = Float.parseFloat(args[0]);
        Float service = Float.parseFloat(args[1]);
        Float discount = Float.parseFloat(args[2]);
        Float total = parts + service - discount;
        System.out.println("Total Price: $" + total);
    }
}
