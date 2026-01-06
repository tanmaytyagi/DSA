package com.dsa.patterns.FastAndSlowPointers;

import com.dsa.algorithms.Arrays.IsSumOfSquareOfDigitsConvergesToOne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSumOfSquareOfDigitsConvergesToOneTest {

    @Test
    void isSumOfSquareOfDigitsConvergesToOneTestCase1() {
        assertTrue(IsSumOfSquareOfDigitsConvergesToOne.isSumOfSquareOfDigitsConvergesToOne(10));
        assertTrue(IsSumOfSquareOfDigitsConvergesToOne.isSumOfSquareOfDigitsConvergesToOne(7));
    }

    @Test
    void isSumOfSquareOfDigitsConvergesToOneTestCase2() {
        assertFalse(IsSumOfSquareOfDigitsConvergesToOne.isSumOfSquareOfDigitsConvergesToOne(4));
    }
}