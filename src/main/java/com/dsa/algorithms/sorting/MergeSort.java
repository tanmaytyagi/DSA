package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Divide and conquer sorting algorithm
 * @Time - O(n log n)
 * @Space - O(n)
 */
public class MergeSort {

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);

        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, low, high - low + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 52, 4, -3, 2, 11 };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
