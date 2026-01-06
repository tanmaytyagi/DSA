package com.dsa.patterns.TwoPointers;

import com.dsa.algorithms.TwoPointers.StrobogrammaticNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrobogrammaticNumberTest {
    @Test
    void testValidStrobogrammaticNumber() {
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("69"));
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("808"));
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("101"));
    }

    @Test
    void testInvalidStrobogrammaticNumber() {
        assertFalse(StrobogrammaticNumber.isStrobogrammatic("a"));
        assertFalse(StrobogrammaticNumber.isStrobogrammatic("2"));
        assertFalse(StrobogrammaticNumber.isStrobogrammatic("89"));
    }

    @Test
    void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () ->
                StrobogrammaticNumber.isStrobogrammatic(""));
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () ->
                StrobogrammaticNumber.isStrobogrammatic(null));
    }
}