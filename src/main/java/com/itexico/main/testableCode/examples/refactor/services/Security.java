package com.itexico.main.testableCode.examples.refactor.services;

import com.itexico.main.testableCode.examples.refactor.entities.User;

public interface Security {
    boolean isAdmin(User user);
}
