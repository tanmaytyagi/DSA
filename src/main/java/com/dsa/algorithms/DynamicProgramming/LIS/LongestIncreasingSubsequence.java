package com.dsa.algorithms.DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // v[i] is length of LIS stored at ith index
    public static int lenLIS(int[] a) {
        int n = a.length;
        int[] v = new int[n];
        Arrays.fill(v, 1);

        for(int i = 1; i < n; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(a[j] < a[i]) v[i] = Math.max(v[i] , v[j] + 1);
            }
        }

        int ans = 1;

        // out of all the endings we are finding the best one
        for(int i = 1 ; i < n ; i++) ans = Math.max(ans , v[i]);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(lenLIS(a));
    }
}
