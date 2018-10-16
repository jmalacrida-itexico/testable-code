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
//
//class House {
//    private Door door;
//    private Window window;
//    private Roof roof;
//
//    public House() {
//        this.door = Door.door();
//        this.window = new Window();
//        this.roof = new Roof();
//    }
//
//    public House(
//            Door door,
//            Window window,
//            Roof roof) {
//        this.door = door;
//        this.window = window;
//        this.roof = roof;
//    }
//
//}
//
//class Estimator{
//    static Long getPrice(Door door, Window window, Roof roof){}
//}
//
//class ObjectA{
//    ObjectB getObjectB(){
//
//    }
//}
//
//class ObjectB{
//    ObjectC getObjectC(){
//
//    }
//}
//
//class ObjectC{
//    ObjectD getObjectD(){
//
//    }
//}
//class ObjectD{}
//class Door {
//    static Door door(){
//
//    }
//}
//
//class Window {
//}
//
//class Roof {
//}
//
//class ServiceLocator {
//    Door getDoor() {
//    }
//
//    Window getWindow() {
//    }
//
//    Roof getRoof() {
//    }
//}


