package com.dsa.algorithms.Arrays;

import java.util.Arrays;

public class KadaneAlgorithm {

    public static int maxSubarraySum(int[] arr) {
        int maxHere = 0;
        int maxSoFar = 0;

        for(int x : arr) {
            maxHere += x;
            if(maxHere < 0) maxHere = 0;
            maxSoFar = Math.max(maxHere, maxSoFar);
        }

        return maxSoFar;
    }

    public static int minSubarraySum(int[] arr) {
        int minHere = 0;
        int minSoFar = 0;

        for(int x : arr) {
            minHere += x;
            if(minHere > 0) minHere = 0;
            minSoFar = Math.min(minHere, minSoFar);
        }

        return minSoFar;
    }

    public static int maxCircularSum(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        int minSubarraySum = minSubarraySum(arr);
        int maxSubarraySum = minSubarraySum(arr);

        return Math.max(maxSubarraySum, totalSum - minSubarraySum);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(a));
        System.out.println(minSubarraySum(a));
        System.out.println(maxCircularSum(a));
    }
}
