package com.dsa.algorithms.DynamicProgramming.UnboundedKnapsack;


/**
 * Given an integer total that represents the target amount of money and a list of integers coins that represents different coin denominations, find the minimum number of coins required to make up the total amount. If it’s impossible to achieve the target amount using the given coins, return -1. If the target amount is 0, return 0.
 */

public class CoinChange {

    // recursive solution
    public static int coinChange(int[] c, int t, int i) {
        int n = c.length;
        if(t == 0) return 0;
        if(i >= n) return -1;

        if(t >= c[i]) {
            int picked = coinChange(c, t - c[i], i);
            int notPicked = coinChange(c, t, i + 1);

            if(picked == -1 && notPicked == -1) return -1;
            else if (picked == -1) {
                return notPicked;
            } else if (notPicked == -1){
                return 1 + picked;
            } else {
                return Math.min(1 + picked, notPicked);
            }
        } else {
            return coinChange(c, t, i + 1);
        }
    }

    // bottom up solution
    public static int coinChange(int [] c, int t) {
        int n = c.length;

        int[][] dp = new int[n+1][t+1];
        for(int i = 0 ; i < n + 1 ; i++) dp[i][0] = 0;
        for(int j = 0 ; j < t + 1 ; j++) dp[0][j] = -1;

        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < t + 1 ; j++) {
                if(j >= c[i-1]) {
                    int picked = dp[i][j - c[i-1]];
                    int notPicked = dp[i-1][j];
                    if(picked == -1 && notPicked == -1) dp[i][j] = -1;
                    else if (picked == -1) {
                        dp[i][j] = notPicked;
                    } else if (notPicked == -1){
                        dp[i][j] = 1 + picked;
                    } else {
                        dp[i][j] = Math.min(1 + picked, notPicked);
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][t];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3,4};
        int total = 11;
        System.out.println(coinChange(coins, total));
    }
}
