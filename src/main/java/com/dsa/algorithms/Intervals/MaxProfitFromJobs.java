package com.dsa.algorithms.Intervals;

import java.util.HashMap;
import java.util.Map;

public class MaxProfitFromJobs {

    public static int bs(int[][] intervals, int lo, int hi, int key) {
        int ans = -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(intervals[mid][1] <= key) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    public static int func(int[][] intervals, int i, Map<Integer, Integer> map) {
        if(i < 0) return 0;

        if(map.containsKey(i)) return map.get(i);

        int picked = intervals[i][2];

        int idx = bs(intervals, 0, i-1 , intervals[i][0]);

        picked += (idx != -1) ? func(intervals, idx, map) : 0;

        int notPicked = func(intervals, i-1, map);

        int ans = Math.max(picked, notPicked);

        map.put(i, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3,50},{2,4,10},{3,5,40},{3,6,70}};
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(func(intervals, intervals.length - 1, map));
    }
}
