package com.dsa.algorithms.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Each list of intervals is pairwise disjoint and in sorted order
 * @1. Sorted order:
 * The intervals are ordered by their start time (usually ascending).
 * @2.	Pairwise disjoint:
 * No two intervals overlap.
 */
public class IntervalsIntersections {

    public static int[][] intervalsIntersection(int[][] intervalsA, int[][] intervalsB) {

        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < intervalsA.length && j < intervalsB.length) {
            int start = Math.max(intervalsA[i][0], intervalsB[j][0]);
            int end = Math.min(intervalsA[i][1], intervalsB[j][1]);

            if(start <= end) result.add(new int[]{start, end});

            if(intervalsA[i][1] < intervalsB[j][1]) i++;
            else j++;
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervalsA = new int[][]{{2,4},{5,7},{8,10}};
        int[][] intervalsB = new int[][]{{1,3},{7,8},{9,12}};
        int[][] result = intervalsIntersection(intervalsA, intervalsB);
        for(int[] interval : result) System.out.print(Arrays.toString(interval));
    }
}
