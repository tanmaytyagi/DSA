package com.dsa.util;

import java.util.PriorityQueue;

@SuppressWarnings("all")
public class HeapUtil {
    public static void main(String[] args) {


        // initialize the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // add an element - O(log n)
        pq.add(10);

        // return top element without removing - return null if empty
        int max = pq.peek();

        // remove and return top element
        int top = pq.poll();

        // size of priority queue
        int size = pq.size();

        // check if empty
        boolean isEmpty = pq.isEmpty();

        System.out.println("max: " + max + ", top: " + top + ", size: " + size);
    }
}
