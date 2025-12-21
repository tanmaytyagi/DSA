package com.dsa.patterns.FastAndSlowPointers;

/**
 * arr contains numbers in range [1, n], with length n + 1.
 * only one number in array appears more than once, find that.
 */
public class FindDuplicateInArray {

    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = arr[0];

        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 2, 1};
        System.out.println(findDuplicate(arr));
    }
}
