package com.dsa.algorithms.Sorting;

import java.util.Arrays;
import static com.dsa.util.CommonMethods.swap;

/**
 * Dutch National Flag Algo : sort array containing only 0s, 1s and 2s
 * @Time - O(n)
 * @Space - O(1)
 */
public class DutchNationalFlagSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        int nextZero = 0;
        int nextTwo = n - 1;
        int curr = 0;

        while (curr <= nextTwo) {
            if(arr[curr] == 1) curr++;
            else if(arr[curr] == 0) swap(arr, nextZero++, curr++);
            else swap(arr, nextTwo--, curr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 2, 0, 2, 1, 2, 0, 0, 0, 1, 2, 1, 0, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
