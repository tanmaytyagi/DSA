package com.dsa.algorithms.BinarySearch;

public class RotatedSorted {

    public static int findInRotatedSorted(int[] a, int k) {
        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if(a[mid] == k) return mid;

            // i to mid is sorted
            if(a[i] <= a[mid]) {
                if(a[i] <= k && k < a[mid]) j = mid - 1;
                else i = mid + 1;
            }
            // mid to j is sorted
            else {
                if(a[mid] < k && k <= a[j]) i = mid + 1;
                else j = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a =  {6,7,8,9,1,2,3,4,5};
        System.out.println(a[findInRotatedSorted(a, 5)]);
    }
}
