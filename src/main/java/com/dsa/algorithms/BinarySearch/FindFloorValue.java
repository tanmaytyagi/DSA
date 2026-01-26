package com.dsa.algorithms.BinarySearch;

public class FindFloorValue {

    public static int findFloor(int[] a, int k) {
        int i = 0;
        int j = a.length - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if(a[mid] <= k) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 7, 7, 7, 8, 8, 9};
        System.out.println(findFloor(a, 11));
    }
}
