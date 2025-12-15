package com.dsa.algorithms.sorting;

import java.util.Arrays;
import static com.dsa.util.CommonMethods.swap;

/**
 * arrange the element in a high low high manner
 * @Time - O(n)
 * @Space - O(1)
 */
public class WaveSort {

    public static void sort(int[] arr) {
        for (int i = 1 ; i < arr.length ; i+=2) {
            if(i == arr.length - 1) {
                if (arr[i] > arr[i-1]) swap(arr, i, i-1);
                return;
            }

            if(arr[i] > arr[i-1]) swap(arr, i, i-1);
            if(arr[i] > arr[i+1]) swap(arr, i, i+1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
