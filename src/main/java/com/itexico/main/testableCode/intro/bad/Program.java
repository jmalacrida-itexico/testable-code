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
/*

class House {
    private Door door;
    private Window window;
    private Roof roof;

    public House(ServiceLocator serviceLocator) {
        this.door = serviceLocator.getDoor();
        this.window = serviceLocator.getWindow();
        this.roof = serviceLocator.getRoof();
    doSomething(null);
    }

    public House(Door door, Window window, Roof roof) {
        this.door = door;
        this.window = window;
        this.roof = roof;
    }

    public void doSomething(ObjectA objectA){
        ObjectD objectD = objectA.getObjectB().getObjectC().getObjectD();

        //...

    }
}

class ObjectA{
    ObjectB getObjectB(){

    }
}

class ObjectB{
    ObjectC getObjectC(){

    }
}

class ObjectC{
    ObjectD getObjectD(){

    }
}
class ObjectD{}
class Door {
}

class Window {
}

class Roof {
}

class ServiceLocator {
    Door getDoor() {
    }

    Window getWindow() {
    }

    Roof getRoof() {
    }
}
*/


