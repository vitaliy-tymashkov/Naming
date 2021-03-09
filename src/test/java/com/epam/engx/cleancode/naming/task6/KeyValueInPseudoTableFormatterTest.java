package com.epam.engx.cleancode.naming.task6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyValueInPseudoTableFormatterTest {

    private static final String EXPECTED_VALUE_ENABLE_TRUE = "+-------------+\n" +
            "|enable _ true|\n" +
            "+-------------+\n";
    private static final String EXPECTED_VALUE_NAME_BOB = "+----------+\n" +
            "|name _ Bob|\n" +
            "+----------+\n";

    @Test
    public void shouldFormatKeyValue() {
        assertEquals(EXPECTED_VALUE_ENABLE_TRUE,
                new KeyValueInPseudoTableFormatter().format("enable", "true"));
        assertEquals(EXPECTED_VALUE_NAME_BOB,
                new KeyValueInPseudoTableFormatter().format("name", "Bob"));
    }
}
