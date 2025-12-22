package com.dsa.algorithms.Sorting;

import java.util.Arrays;

/**
 * when data is in a certain small range [a , b] where a,b are integers
 * @Time - O(n + range)
 * @Space - O(range)
 */
public class CountingSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int minValue = arr[0];
        int maxValue = arr[0];

        for (int elem : arr) {
            if (elem < minValue) minValue = elem;
            if (elem > maxValue) maxValue = elem;
        }

        int range = maxValue - minValue + 1;
        int[] temp = new int[range];

        for (int elem : arr) temp[elem - minValue]++;

        int index = 0;
        for (int i = 0 ; i < temp.length ; i++) {
            while (temp[i] > 0) {
                arr[index++] = minValue + i;
                temp[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-2, -5, 3, 0, -2, 4, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
