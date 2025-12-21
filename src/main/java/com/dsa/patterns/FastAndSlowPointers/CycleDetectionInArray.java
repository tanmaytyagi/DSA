package com.dsa.patterns.FastAndSlowPointers;

public class CycleDetectionInArray {

    public static boolean circularArrayLoop(int[] a) {
        int n = a.length;
        for(int i = 0 ; i < n ; i++) a[i] = a[i] % n;

        for(int i = 0 ; i < n ; i++) {
            if(a[i] == 0) continue;

            int slow = i;
            int fast = i;
            slow = nextIndex(slow, a[slow], n);
            fast = nextIndex(fast, a[fast], n);
            fast = nextIndex(fast, a[fast], n);
            if(a[i] > 0) {
                while(a[slow] != 0 && a[fast] != 0 && a[slow] > 0 && a[fast] > 0) {
                    if(slow == fast) return true;
                    slow = nextIndex(slow, a[slow], n);
                    fast = nextIndex(fast, a[fast], n);
                    fast = nextIndex(fast, a[fast], n);
                }
            } else {
                while(a[slow] != 0 && a[fast] != 0 && a[slow] < 0 && a[fast] < 0) {
                    if(slow == fast) return true;
                    slow = nextIndex(slow, a[slow], n);
                    fast = nextIndex(fast, a[fast], n);
                    fast = nextIndex(fast, a[fast], n);
                }
            }
        }

        return false;
    }

    public static int nextIndex(int currIdx, int value, int size) {
        if(value > 0) {
            currIdx += value;
            return currIdx % size;
        } else {
            int x = size + value;
            currIdx += x;
            return currIdx % size;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, -3, 1, -3, 2};
        int[] arr2 = {1, 4, 3, 2, 1};
        int[] arr3 = {2, 5, -4, 3, -1, 4};
        System.out.println(circularArrayLoop(arr3));
    }
}
