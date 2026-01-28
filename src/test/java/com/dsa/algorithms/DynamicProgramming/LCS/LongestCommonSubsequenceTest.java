package com.dsa.algorithms.DynamicProgramming.LCS;

import org.junit.jupiter.api.Test;

import static com.dsa.algorithms.DynamicProgramming.LCS.LongestCommonSubsequence.lcs;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {

    @Test
    void test1() {
        String s1 = "abcde";
        String s2 = "abc";
        assertEquals(3, lcs(s1, s2));
    }

    @Test
    void test2() {
        String s1 = "";
        String s2 = "abc";
        assertEquals(0, lcs(s1, s2));
    }
}