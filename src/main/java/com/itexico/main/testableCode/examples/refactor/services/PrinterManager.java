package com.itexico.main.testableCode.examples.refactor.services;

public interface PrinterManager {

    void initialize();

    void acquireLock();

    void releaseLock();
}
