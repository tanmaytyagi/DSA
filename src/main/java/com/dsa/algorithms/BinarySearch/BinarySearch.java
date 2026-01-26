package com.dsa.algorithms.BinarySearch;

public class BinarySearch {

    public static int binarySearch(int[] a, int k) {
        int i = 0;
        int j = a.length - 1;

        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(a[mid] == k) return mid;
            else if(a[mid] < k) i = mid + 1;
            else j = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(a, 7));
    }
}
