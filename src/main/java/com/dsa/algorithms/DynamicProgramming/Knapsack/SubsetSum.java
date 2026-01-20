package com.dsa.algorithms.DynamicProgramming.Knapsack;


// Given a set of non-negative integers, and a value sum, determine if there is a
// subset of the given set with sum equal to given sum.

public class SubsetSum {

    // recursive approach
    public static boolean func(int[] a, int k , int n) {
        if(k == 0) return true;
        if(n == 0) return false;

        if(k >= a[n-1]) {
            return func(a, k - a[n-1], n-1) || func(a, k, n-1);
        } else {
            return func(a, k, n-1);
        }
    }

    // bottom up
    public static boolean func2(int[] a, int k, int n) {
        boolean[][] dp = new boolean[n+1][k+1];
        for(int j = 0 ; j <= k ; j++) dp[0][k] = false;
        for(int i = 0 ; i <= n ; i++) dp[i][0] = true;

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= k ; j++) {
                if(j >= a[i-1]) {
                    dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }

    public static boolean subsetSum(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int j : a) sum += j;
        if(sum % 2 == 1) return false;
        return func2(a, sum/2, n);
    }

    public static void main(String[] args) {
        int[] a = {1,6,20,7,8};
        System.out.println(subsetSum(a));
    }
}
