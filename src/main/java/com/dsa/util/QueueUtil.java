package com.dsa.util;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class QueueUtil {
    public static void main(String[] args) {

        // inbuilt queue implemented over LinkedList
        Queue<Integer> queue = new LinkedList<>();

        queue.add(5);
        queue.add(2);

        int a = queue.remove();

        int b = queue.peek();

        int s = queue.size();

        boolean isEmpty = queue.isEmpty();

        System.out.println(a +  " " + b + " " + s + " " + isEmpty);
    }
}
