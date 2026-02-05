package com.dsa.algorithms.DynamicProgramming.LinerDP;


/**
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobber1 {

    public static int maxRobberyProfit(int[] houses, int i) {
        int n = houses.length;
        if(i >= n) return 0;

        int currLooted = houses[i] + maxRobberyProfit(houses, i + 2);
        int currNotLooted = maxRobberyProfit(houses, i + 1);
        return Math.max(currNotLooted, currLooted);
    }

    public static int maxRobberyProfit(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for(int i = 2; i < n; i++) {
            int currLooted = houses[i] + dp[i - 2];
            int currNotLooted = dp[i - 1];
            dp[i] = Math.max(currNotLooted, currLooted);
        }
        return dp[n-1];
    }

    public static int maxRobberyProfitOptimal(int[] houses) {
        int n = houses.length;
        if(n == 0) return 0;
        if(n == 1) return houses[0];

        int past = houses[0];
        int prev = Math.max(houses[0], houses[1]);

        for(int i = 2; i < n; i++) {
            int currLooted =  houses[i] + past;
            int currNotLooted = prev;
            int currMax = Math.max(currNotLooted, currLooted);

            past = prev;
            prev = currMax;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,1};
        System.out.println(maxRobberyProfit(houses, 0));
        System.out.println(maxRobberyProfit(houses));
        System.out.println(maxRobberyProfitOptimal(houses));
    }
}
