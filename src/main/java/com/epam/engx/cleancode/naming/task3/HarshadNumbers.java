package com.epam.engx.cleancode.naming.task3;

public class HarshadNumbers {

	/**
	 Print some Harshad numbers (limited by 200L)
	 */
	public String main() {
		StringBuilder result = new StringBuilder();
		long limitValue = 200L;
		int i = 1;
		while (i <= limitValue) {
			if (isHarshadNumber(i)) {
				result.append(i).append("\n");
			}
			i++;
		}
		return result.toString();
	}

	private boolean isHarshadNumber(int currentNumber) {
		int initialValue = currentNumber;
		int counter = 0;
		while (currentNumber != 0) {
            counter += currentNumber % 10;
            currentNumber = currentNumber / 10;
        }
		return ((initialValue % counter) == 0);
	}
}
