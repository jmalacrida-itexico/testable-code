package com.itexico.main.testableCode.intro.good;

public class Program {

    public static void main(String... args) {
        Float parts = Float.parseFloat(args[0]);
        Float service = Float.parseFloat(args[1]);
        Float discount = Float.parseFloat(args[2]);

        Calculator calculator = new Calculator();

        Float total = calculator.getTotal(parts, service, discount);
        System.out.println("Total Price: $" + total);
    }
}
