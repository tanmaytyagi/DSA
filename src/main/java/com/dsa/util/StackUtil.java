package com.dsa.util;

import java.util.Stack;

public class StackUtil {

    public static void main(String[] args) {

        // ========= ALL OPERATIONS in O(1) ===========

        Stack<Integer> stack = new Stack<>();

        stack.push(1);                  // returns <E>

        stack.peek();                        // returns <E> or empty stack exception

        stack.pop();                         // returns <E> or empty stack exception

        boolean isEmpty = stack.isEmpty();   // returns boolean

        int size = stack.size();             // returns int
    }
}
