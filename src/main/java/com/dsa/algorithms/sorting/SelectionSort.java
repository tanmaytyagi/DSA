package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Perform forward iteration from each element,
 * in each iteration pick the smallest and save it inplace of that elem by swapping
 * @Time - O(n^2)
 * @Space - O(1)
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = minValue;
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
