package com.dsa.patterns.FastAndSlowPointers;

public class CycleDetectionInArray {

    public static boolean circularArrayLoop(int[] a) {
        int n = a.length;
        for(int i = 0 ; i < n ; i++) a[i] = a[i] % n;

        for(int i = 0 ; i < n ; i++) {
            if(a[i] == 0) continue;
            int slow = i;
            int fast = i;

            if(a[i] > 0) {
                while(a[slow] != 0 && a[fast] != 0 && a[slow] > 0 && a[fast] > 0) {
                    slow = nextIndex(slow, a[slow], n);
                    fast = nextIndex(fast, a[fast], n);
                    if(a[fast] <= 0) break;
                    fast = nextIndex(fast, a[fast], n);
                    if(slow == fast) return true;
                }
            } else {
                while(a[slow] != 0 && a[fast] != 0 && a[slow] < 0 && a[fast] < 0) {
                    slow = nextIndex(slow, a[slow], n);
                    fast = nextIndex(fast, a[fast], n);
                    if(a[fast] >= 0) break;
                    fast = nextIndex(fast, a[fast], n);
                    if(slow == fast) return true;
                }
            }
        }

        return false;
    }

    public static int nextIndex(int currIdx, int value, int size) {
        if(value > 0) {
            currIdx += value;
        } else {
            int x = size + value;
            currIdx += x;
        }
        return currIdx % size;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, -3, 1, -3, 2};
        int[] arr2 = {1, 4, 3, 2, 1};
        int[] arr3 = {2, 5, -4, 3, -1, 4};
        int[] arr4 = {1,1,1,1,1,1,1,1,1,-5};
        System.out.println(circularArrayLoop(arr4));
    }
}
