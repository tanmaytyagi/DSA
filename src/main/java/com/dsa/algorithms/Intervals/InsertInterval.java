package com.dsa.algorithms.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        int start = newInterval[0];
        int end   = newInterval[1];

        while (i < n && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end   = Math.max(end, intervals[i][1]);
            i++;
        }

        result.add(new int[]{start, end});

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{3,4},{5,10}};
        intervals = insertInterval(intervals, new int[]{10,15});
        for(int[] interval : intervals) System.out.print(Arrays.toString(interval));
    }
}
