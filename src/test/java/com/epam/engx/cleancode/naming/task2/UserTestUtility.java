package com.epam.engx.cleancode.naming.task2;

public class UserTestUtility {

    public UserTestUtility() {
        throw new UnsupportedOperationException();
    }

    public static User getAdminUser(User user) {
        user.setAdmin(true);
        return user;
    }
}
