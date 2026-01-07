package com.dsa.util;
import java.util.Arrays;
import java.util.Comparator;


@SuppressWarnings("all")
public class ArrayUtils {

    public static void main(String[] args) {

        // ================== FOR PRIMITIVE ARRAYS ==================

        int[] a0 = {1, 2, 3, 4, 5};
        int[] a1 = new int[]{1, 2, 3, 4, 5};
        int[] a2 = new int[10]; // default 0

        // size of array
        int n = a0.length;

        // for loop in array
        for (int i = 0; i < n; i++) System.out.println(a0[i]);

        // for each loop in array
        for(int x : a2) System.out.println(x);

        // ascending sort only
        Arrays.sort(a0);

        // binary search sorted array
        int idx = Arrays.binarySearch(a0, 1, 4, 2);

        // print the array
        System.out.println(Arrays.toString(a0));





        // ================== FOR NON PRIMITIVE ARRAYS ==================

        Integer[] b0 = {1, 2, 3, 4, 5};
        Integer[] b1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] b2 = new Integer[10]; // default = null
        String[] b3 = new String[]{"apple", "ball", "cat", "dog"};

        // for each loop
        for (Integer x : b0) System.out.println(x);

        // ascending sort
        Arrays.sort(b0);

        // descending order
        Arrays.sort(b0, (a, b) -> b - a);

        // custom order
        Arrays.sort(b3, (a,b) -> { return a.length() - b.length();});

        // print the array
        System.out.println(Arrays.toString(b3));





        // ================== FOR NESTED ARRAYS ==================

        int[][] c0 = new int[10][2];

        Comparator<int[]> ascInterval = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };

        // print nested array
        System.out.println(Arrays.deepToString(c0));
    }
}
