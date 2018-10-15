package com.itexico.main.testableCode.examples.original;

class Security {
    private static Security INSTANCE = null;

    private Security() {
    }

    public static Security getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Security();
        return INSTANCE;
    }

    public boolean isAdmin(User user) {
        return true;
    }
}
