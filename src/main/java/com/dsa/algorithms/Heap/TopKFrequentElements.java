package com.dsa.algorithms.Heap;

import java.util.*;

// The entrySet() method in Java is a core part of the Map interface.
// It provides a Set view of all the key-value mappings contained within a map,
// where each element is an object of type Map.Entry<K, V>.
// This approach is the most efficient way to iterate over a map when
// you need access to both the keys and their corresponding values

public class TopKFrequentElements {

    // T -> O(NlogK)

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0);
            map.put(num, ++freq);
        }

        // min-heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = pq.poll().getKey();
        return res;
    }


    // Bucket sort -> T : O(n)

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0);
            map.put(num, ++freq);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int num = e.getKey();
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(num);
        }

        int[] res = new int[k];
        int idx = 0;

        for(int f = nums.length; f >= 1 && idx < k ; f--) {
            if(buckets[f] == null) continue;
            for(int num : buckets[f]) {
                res[idx++] = num;
                if(idx == k) break;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent2(nums, k)));
    }
}
