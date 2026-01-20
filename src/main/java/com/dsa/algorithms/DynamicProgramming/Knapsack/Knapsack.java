package com.dsa.algorithms.DynamicProgramming.Knapsack;

// Given weights and values of n items, put these items in a knapsack of
// capacity W to get the maximum total value in the knapsack

// find out the maximum value subset of val[] such that sum of the weights of this
// subset is smaller than or equal to c (capacity). You cannot break an item.
// either pick the complete item or don’t pick it (0-1 property).

public class Knapsack {

    // first write the recursive code
    public static int maxValue(int[] w, int[] v, int c, int i) {
        int n = w.length;
        if(i >= n) return 0;

        if(c >= w[i]) {
            return Math.max(v[i] + maxValue(w,v,c-w[i],i+1), maxValue(w,v,c, i+1));
        } else {
            return maxValue(w,v,c,i+1);
        }
    }

    // then boil it down to "bottom up" / "tabulation"
    public static int maxValue(int[] w, int[] v , int c) {
        int n =  w.length;
        int[][] dp = new int[n][c+1];

        for(int wt = 0 ; wt <= c ; wt++) {
            if(wt >= w[0]) dp[0][wt] = v[0];
        }

        for(int i = 1 ; i < n ; i++) {
            for(int wt = 0 ; wt <= c ; wt++) {
                if(wt >= w[i]) {
                    dp[i][wt] = Math.max(v[i] + dp[i-1][wt-w[i]], dp[i-1][wt]);
                } else {
                    dp[i][wt] = dp[i-1][wt];
                }
            }
        }

        return dp[n-1][c];
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {22, 33, 44};
        int capacity = 30;

        int maxValue = maxValue(weights, values, capacity);
        System.out.println(maxValue);
    }
}
