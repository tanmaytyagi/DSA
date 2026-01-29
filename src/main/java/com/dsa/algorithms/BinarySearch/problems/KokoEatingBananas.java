package com.dsa.algorithms.BinarySearch.problems;

import java.util.Arrays;

public class KokoEatingBananas {

    public static boolean canEat(int[] p, int h , int k) {
        for (int j : p) {
            int dividend = j / k;
            int remainder = j % k;

            h = h - dividend;
            if (remainder != 0) h--;
        }
        return h >= 0;
    }

    public static int minEatingSpeed(int[] p, int h) {
        if(p == null || p.length == 0) return 0;

        int i = 1;
        int j = Arrays.stream(p).max().getAsInt();

        int ans = 1;

        while(i <= j) {
            int mid = i + (j - i)/2;
            if(canEat(p, h, mid)) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}
