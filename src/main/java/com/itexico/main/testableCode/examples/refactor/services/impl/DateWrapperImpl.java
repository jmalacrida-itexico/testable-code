package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.services.DateWrapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateWrapperImpl implements DateWrapper {
    @Override
    public String getNowAsIsoLocalDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
