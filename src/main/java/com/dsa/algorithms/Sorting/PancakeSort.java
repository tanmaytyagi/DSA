package com.dsa.algorithms.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dsa.util.ArrayUtil.reverse;

/**
 * Given an array of integers arr, sort the array by performing a series of pancake flips.
 *
 * In one pancake flip we do the following steps:
 *
 * Choose an integer k where 1 <= k <= arr.length.
 * Reverse the sub-array arr[0...k-1] (0-indexed).
 * For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
 *
 * Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
 */

public class PancakeSort {

    public static int largeIndex(int[] a , int i , int j) {
        int max = a[i];
        int maxIdx = i;
        while(i <= j) {
            if(a[i] > max) {
                maxIdx = i;
                max = a[i];
            }
            i++;
        }
        return maxIdx;
    }


    public static List<Integer> pancakeSort(int[] a) {
        List<Integer> ans = new ArrayList<>();
        for(int i = a.length - 1 ; i >= 0 ; i--) {
            int idx = largeIndex(a, 0, i);
            if(idx == i) continue;
            if(idx == 0) {
                reverse(a, 0, i);
                ans.add(i + 1);
                continue;
            }
            reverse(a, 0 , idx);
            reverse(a , 0 , i);
            ans.add(idx + 1);
            ans.add(i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,5,4};
        List<Integer> list = pancakeSort(arr);
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }
}
