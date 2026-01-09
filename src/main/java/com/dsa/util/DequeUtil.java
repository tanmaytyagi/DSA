package com.dsa.util;

// ArrayDeque uses Resizable circular array Not Doubly linked list
// ArrayDeque is used as FIFO (queue) and LIFO (stack) both ways
// ArrayDeque is dynamically resizing and effectively unbounded for DSA

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeUtil {
    public static void main(String[] args) {

        // initialization
        Deque<Integer> deque = new ArrayDeque<>();

        // insert -> returns void
        deque.addFirst(1);
        deque.addLast(2);

        // remove
        deque.pollFirst();                      // if empty returns null
        deque.pollLast();                       // if empty returns null

        // read
        Integer first = deque.peekFirst();      // if empty returns null
        Integer last = deque.peekLast();        // if empty returns null

        // check empty
        boolean flag = deque.isEmpty();

        // get size
        int n = deque.size();

        // clear the deque
        deque.clear();
    }
}
