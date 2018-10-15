package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.services.PrinterManager;

public class PrinterManagerImpl implements PrinterManager {

    @Override
    public void initialize() {
        System.out.println("printer manager initialized");
    }

    @Override
    public void acquireLock() {

    }

    @Override
    public void releaseLock() {

    }
}
