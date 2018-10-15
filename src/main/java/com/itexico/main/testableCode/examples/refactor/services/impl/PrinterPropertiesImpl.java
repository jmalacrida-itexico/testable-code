package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.services.PrinterProperties;

public class PrinterPropertiesImpl implements PrinterProperties {
    @Override
    public String getOverdueColor() {
        return "red";
    }

    @Override
    public String getDefaultColor() {
        return "black";
    }
}
