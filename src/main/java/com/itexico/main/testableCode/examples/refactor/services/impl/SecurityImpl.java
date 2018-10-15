package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.User;
import com.itexico.main.testableCode.examples.refactor.services.Security;

public class SecurityImpl implements Security {
    @Override
    public boolean isAdmin(User user) {
        return true;
    }
}
