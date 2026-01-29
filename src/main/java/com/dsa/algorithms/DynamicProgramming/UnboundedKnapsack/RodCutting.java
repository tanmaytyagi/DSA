package com.dsa.algorithms.DynamicProgramming.UnboundedKnapsack;

public class RodCutting {

    public static int func(int[] prices, int[] length, int rodLength) {
        int n = prices.length;
        int[][] dp = new int[n+1][rodLength+1];

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= rodLength ; j++) {
                if(length[i-1] > j) dp[i][j] = dp[i-1][j];
                else {
                    int picked = prices[i-1] + dp[i][j-length[i-1]];
                    int notPicked = dp[i-1][j];
                    dp[i][j] = Math.max(picked, notPicked);
                }
            }
        }

        return dp[n][rodLength];
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8}; // if not given make it
        int rodLength = 8; // if not given rodLength = prices.length

        System.out.println(func(prices, length, rodLength));
    }
}
