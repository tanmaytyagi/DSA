package com.dsa.algorithms.BitManipulation;
import java.util.Arrays;


// For a given positive integer n, your task is to return an array of length n + 1
// for each i, 0 <= i <= n, result[i] = count of 1's in binary representation of i

public class CountingBits {

    public static int[] countingBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(i % 2 == 0) {
                result[i] = result[i/2];
            } else {
                result[i] = result[i/2] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingBits(10)));
    }
}
