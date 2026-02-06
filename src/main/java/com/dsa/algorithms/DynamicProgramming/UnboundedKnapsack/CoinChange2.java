package com.dsa.algorithms.DynamicProgramming.UnboundedKnapsack;

// You are given an integer array coins representing coins of different denominations
// and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

public class CoinChange2 {

    public static int noOfWays(int[] coins, int amount, int i) {
        int n = coins.length;
        if(i >= n) return 0;
        if(amount < 0) return 0;
        if(amount == 0) return 1;

        int pickedWays = noOfWays(coins, amount - coins[i] , i);
        int notPickedWays = noOfWays(coins, amount , i+1);

        return pickedWays + notPickedWays;
    }

    public static int noOfWays(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {
                int currCoin = coins[i-1];
                if(j > currCoin) {
                    // picked + notPicked
                    dp[i][j] = dp[i-1][j] + dp[i][j-currCoin];
                } else if (j == currCoin) {
                    // 1 way by picking the currCoin + notPicked
                    dp[i][j] = 1 + dp[i-1][j];
                } else {
                    // cannot pick curr thus => notPicked
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        System.out.println(noOfWays(coins, amount, 0));
        System.out.println(noOfWays(coins, amount));
    }
}
