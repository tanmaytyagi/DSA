package com.dsa.patterns.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        if(intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> result = new ArrayList<>();

        int[] prev = new int[2];
        prev[0] = intervals[0][0];
        prev[1] = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(prev[1] >= intervals[i][0]) prev[1] = Math.max(prev[1], intervals[i][1]);
            else {
                result.add(prev);
                prev = intervals[i];
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,4},{5,6}};
        intervals = mergeIntervals(intervals);
        for(int[] interval : intervals) System.out.print(Arrays.toString(interval));
    }
}
