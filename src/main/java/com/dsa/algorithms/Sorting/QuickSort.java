package com.dsa.algorithms.Sorting;

import java.util.Arrays;

import static com.dsa.util.ArrayUtil.swap;

public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int cnt = 0;
        for (int i = low; i <= high; i++) if(arr[i] < pivot) cnt++;

        swap(arr, low, low + cnt);

        int i = low;
        int j = high;
        int p = low + cnt;

        while (i < p && j > p) {
            if (arr[i] >= pivot && arr[j] < pivot) swap(arr, i++, j--);
            else if (arr[i] >= pivot) j--;
            else i++;
        }

        return p;
    }

    public static void sort(int[] arr, int low, int high) {
        if(low >= high) return;

        int pivot = partition(arr, low, high);

        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-5, 4, 3, -2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
