package com.dsa.patterns.TwoPointers;

import com.dsa.algorithms.TwoPointers.MinAdjacentSwapToMakePalindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinAdjacentSwapToMakePalindromeTest {

    @Test
    void validTestCases() {
        assertEquals(0, MinAdjacentSwapToMakePalindrome.minMovesToMakePalindrome("abba"));
        assertEquals(1, MinAdjacentSwapToMakePalindrome.minMovesToMakePalindrome("abab"));
    }
}