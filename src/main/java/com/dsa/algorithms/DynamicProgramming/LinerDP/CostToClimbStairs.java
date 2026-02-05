package com.dsa.algorithms.DynamicProgramming.LinerDP;


/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */

public class CostToClimbStairs {

    public static int costToClimbStairs(int[] c, int n) {
        if(n <= 1) return 0;

        int cameFromPrev = c[n-1] + costToClimbStairs(c, n-1);
        int cameFromPast = c[n-2] + costToClimbStairs(c, n-2);

        return Math.min(cameFromPrev, cameFromPast);
    }

    public static int costToClimbStairs(int[] c) {
        int n = c.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int cameFromPrev = c[i-1] + dp[i-1];
            int cameFromPast = c[i-2] + dp[i-2];
            dp[i] = Math.min(cameFromPrev, cameFromPast);
        }

        return dp[n];
    }

    public static int costToClimbStairsOptimal(int[] c) {
        int n = c.length;
        int prev = 0;
        int past = 0;

        for (int i = 2; i <= n; i++) {
            int cameFromPrev = c[i-1] + prev;
            int cameFromPast = c[i-2] + past;
            int curr = Math.min(cameFromPrev, cameFromPast);

            past = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] c = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(costToClimbStairs(c, c.length));
        System.out.println(costToClimbStairs(c));
        System.out.println(costToClimbStairsOptimal(c));
    }
}
