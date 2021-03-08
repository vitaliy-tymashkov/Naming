package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String PLUS = "+";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = " _ ";
    private static final String NEW_LINE = "\n";


    public String formatKeyValue(String key, String value) {
        String content = key + UNDERSCORE + value;
        String minuses = repeat(MINUS, content.length());

        StringBuilder result = new StringBuilder();
        result.append(PLUS).append(minuses).append(PLUS).append(NEW_LINE)
                .append(PIPE).append(content).append(PIPE).append(NEW_LINE)
                .append(PLUS).append(minuses).append(PLUS).append(NEW_LINE);

        return result.toString();
    }

    private String repeat(String symbol, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++)
            result.append(symbol);
        return result.toString();
    }
}
