package com.dsa.patterns.TwoPointers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidWordAbbreviationTest {

    @Test
    void testValidAbbreviations() {
        assertTrue(ValidWordAbbreviation.validWordAbbreviation("calendar", "c6r"));
        assertTrue(ValidWordAbbreviation.validWordAbbreviation("abcdefg", "1b3f1"));
    }

    @Test
    void testInvalidAbbreviations() {
        assertFalse(ValidWordAbbreviation.validWordAbbreviation("calendar", "c24r"));
        assertFalse(ValidWordAbbreviation.validWordAbbreviation("abcdefg", "01b3f1"));
    }

    @Test
    void testEdgeCases() {
        assertTrue(ValidWordAbbreviation.validWordAbbreviation("", ""));
        assertFalse(ValidWordAbbreviation.validWordAbbreviation("a", ""));
        assertFalse(ValidWordAbbreviation.validWordAbbreviation("", "1"));
    }
}
