package com.dsa.algorithms.Arrays.TwoPointers;
import java.util.Arrays;


/**
 * count number of pairs (i,j) 0 ≤ i < j < n such that a[i]+a[j] is strictly less than the k.
 * @Time - O(nlogn)
 * @Space - O(n)
 */
public class CountPairsSumLessThanTarget {
    public static int countPairsSumLessThanTarget(int[] a, int k) {
        Arrays.sort(a);

        int count = 0;
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            if(a[i] + a[j] >= k) j--;
            else {
                count += j - i;
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,6,8,-1,0,-4,12,1};
        int target = 6;
        System.out.println(countPairsSumLessThanTarget(arr, target));
    }
}
