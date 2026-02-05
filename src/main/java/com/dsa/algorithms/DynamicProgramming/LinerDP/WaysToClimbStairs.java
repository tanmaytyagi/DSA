package com.dsa.algorithms.DynamicProgramming.LinerDP;


/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */

public class WaysToClimbStairs {

    public static int waysToClimbStairs(int n) {
        if(n <= 1) return 1;
        return waysToClimbStairs(n - 1) + waysToClimbStairs(n - 2);
    }

    public static int waysToClimbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int waysToClimbStairs3(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int oneStepBack = 2;
        int twoStepBack = 1;

        for(int i = 3; i <= n; i++) {
            int currStep = oneStepBack + twoStepBack;
            twoStepBack = oneStepBack;
            oneStepBack = currStep;
        }
        return oneStepBack;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(waysToClimbStairs3(n));
    }
}
