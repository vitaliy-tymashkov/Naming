package com.epam.engx.cleancode.naming.task6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    private static final String EXPECTED_VALUE_ENABLE_TRUE = "+-------------+\n" +
            "|enable _ true|\n" +
            "+-------------+\n";
    private static final String EXPECTED_VALUE_NAME_BOB = "+----------+\n" +
            "|name _ Bob|\n" +
            "+----------+\n";

    @Test
    public void shouldFormatKeyValue() {
        assertEquals(EXPECTED_VALUE_ENABLE_TRUE,
                new Formatter().formatKeyValue("enable", "true"));
        assertEquals(EXPECTED_VALUE_NAME_BOB,
                new Formatter().formatKeyValue("name", "Bob"));
    }
}
