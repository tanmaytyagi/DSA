package com.dsa.algorithms.DynamicProgramming.LinerDP;

public class HouseRobber2 {

    public static int func(int[] houses, int i, int j) {
        int past = 0;
        int prev = 0;

        for(int k = i ; k <= j ; k++) {
            int currLooted = houses[k] + past;
            int currNotLooted = prev;
            int currMaxProfit = Math.max(currNotLooted, currLooted);

            past = prev;
            prev = currMaxProfit;
        }

        return prev;
    }

    public static int maxRobberyProfitInCircular(int[] houses) {
        int n = houses.length;

        if(n == 0) return 0;
        if(n == 1) return houses[0];

        int x = func(houses, 0, n-2);
        int y = func(houses, 1, n-1);

        return Math.max(x,y);
    }

    public static void main(String[] args) {
        int[] houses = {2,3,2};
        System.out.println(maxRobberyProfitInCircular(houses));
    }
}
