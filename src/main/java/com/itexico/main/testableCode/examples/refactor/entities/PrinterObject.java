package com.itexico.main.testableCode.examples.refactor.entities;

import java.util.ArrayList;
import java.util.List;

public class PrinterObject {

    private String pageColor;
    private List<String> lines = new ArrayList<>();

    public String getPageColor() {
        return pageColor;
    }

    public List<String> getLines() {
        return lines;
    }

    public PrinterObject withPageColor(String pageColor) {
        this.pageColor = pageColor;
        return this;
    }

    public PrinterObject appendLine(String line) {
        lines.add(line);
        return this;
    }
}
