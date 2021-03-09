package com.epam.engx.cleancode.naming.task3;

public class HarshadNumbersProvider {

	private static final int DECIMAL_BASE = 10;
    private static final long LIMIT_VALUE = 200L;
	private static final String NEW_LINE = "\n";

	public String getNumbers() {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= LIMIT_VALUE; i++) {
            if (isHarshadNumber(i)) {
                result.append(i).append(NEW_LINE);
            }
        }
        return result.toString();
    }

    private boolean isHarshadNumber(int currentNumber) {
        int initialValue = currentNumber;
        int counter = 0;
        while (currentNumber != 0) {
            counter += currentNumber % DECIMAL_BASE;
            currentNumber = currentNumber / DECIMAL_BASE;
        }
        return isZeroReminder(initialValue, counter);
    }

    private boolean isZeroReminder(int initialValue, int counter) {
        return (initialValue % counter) == 0;
    }
}
