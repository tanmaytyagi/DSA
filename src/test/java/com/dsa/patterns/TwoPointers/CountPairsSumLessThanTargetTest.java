package com.dsa.patterns.TwoPointers;

import com.dsa.algorithms.TwoPointers.CountPairsSumLessThanTarget;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPairsSumLessThanTargetTest {

    @Test
    void validTestCase() {
        int[] arr = {3,2,6,8,-1,0,-4,12,1};
        int target = 6;
        assertEquals(18, CountPairsSumLessThanTarget.countPairsSumLessThanTarget(arr, target));
    }

    @Test
    void invalidTestCase() {
        int[] arr = {3,3};
        int target = 6;
        assertEquals(0, CountPairsSumLessThanTarget.countPairsSumLessThanTarget(arr, target));
    }
}