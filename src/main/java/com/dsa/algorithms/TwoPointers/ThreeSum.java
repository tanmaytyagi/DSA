package com.dsa.algorithms.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an integer array, nums[], find and return all unique triplets with sum 0
 * @Time - O(n^2)
 * @Space - O(1)
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int low = i + 1, high = nums.length - 1;
            while(low < high) {
                if(low > i + 1 && nums[low] == nums[low-1]) low++;
                else if(nums[i] +  nums[low] + nums[high] < 0) low++;
                else if(nums[i] +  nums[low] + nums[high] > 0) high--;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    result.add(list);
                    low++;
                    high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 2, -2, 1, -1};

        int[] sorted = {-2,-1,-1,-1,-1,3,3,3,3,3,3};

        int[] zeros = {0,0,0,0,0,0,0,0,0,0,0,0};
        List<List<Integer>> ans = threeSum(arr);
        System.out.println(ans);
    }
}
