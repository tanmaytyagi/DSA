package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Build the sorted array one element at a time
 * by inserting each element into its correct position in the already sorted part.
 * @Time - O(n^2)
 * @Space - O(1)
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // shift right
                j--;
            }
            arr[j + 1] = key; // insert at correct position
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
