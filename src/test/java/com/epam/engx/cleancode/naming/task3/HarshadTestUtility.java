package com.epam.engx.cleancode.naming.task3;

public final class HarshadTestUtility {

    private HarshadTestUtility() {
        throw new UnsupportedOperationException();
    }

    public static String getHarshadNumbers() {
        return new HarshadNumbersProvider().getNumbers();
    }
}
