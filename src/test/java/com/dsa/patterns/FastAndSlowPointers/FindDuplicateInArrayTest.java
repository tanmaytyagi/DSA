package com.dsa.patterns.FastAndSlowPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicateInArrayTest {

    @Test
    void validTestCases() {
        assertEquals(1, FindDuplicateInArray.findDuplicate(new int[]{1, 2, 3, 1}));
        assertEquals(2, FindDuplicateInArray.findDuplicate(new int[]{1, 2, 2, 2}));
        assertEquals(3, FindDuplicateInArray.findDuplicate(new int[]{3, 2, 3, 1, 5}));
    }
}