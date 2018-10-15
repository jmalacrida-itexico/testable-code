package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.User;
import com.itexico.main.testableCode.examples.refactor.services.Identity;

public class IdentityImpl implements Identity {
    @Override
    public User getCurrentUser() {
        User user = new User();
        user.setUsername("User 1");
        return user;
    }
}
