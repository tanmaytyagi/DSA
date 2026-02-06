package com.dsa.organisation.tekion;

import java.util.Arrays;

// The distance of a pair of integers a and b is defined as
// the absolute difference between a and b.
// Given an integer array nums and an integer k
// return the kth smallest distance among all the pairs nums[i] and nums[j]
// where 0 <= i < j < nums.length.

public class KthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int minDistance = 0;
        int maxDistance = nums[n - 1] - nums[0];

        while(minDistance < maxDistance) {
            int midDistance = minDistance + (maxDistance - minDistance) / 2;
            int pairsCount = countPairsWithinDistance(nums, midDistance);

            if(pairsCount < k) {
                minDistance = midDistance + 1;
            } else {
                maxDistance = midDistance;
            }
        }

        return minDistance;
    }


    // sliding window
    // for each right, check what all lefts can it pair with to have distance within target
    public static int countPairsWithinDistance(int[] nums, int targetDistance) {
        int count = 0;
        int left = 0;

        for(int right = 1; right < nums.length ; right++) {
            while(nums[right] - nums[left] > targetDistance) {
                left++;
            }
            count += right - left;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1};
        System.out.println(smallestDistancePair(nums, 1));
    }
}
