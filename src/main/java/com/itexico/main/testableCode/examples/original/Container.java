package com.itexico.main.testableCode.examples.original;

class Container {

    Database getDatabase() {
        return new Database();
    }

    Session getSession() {
        return new Session();
    }
}
