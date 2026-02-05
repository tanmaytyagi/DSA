package com.dsa.algorithms.Arrays;

import java.util.Stack;

public class MaxRectangleInHistogram {

    public static int[] nextSmallerElement(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) stack.pop();
            if(stack.isEmpty()) result[i] = n;
            else result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }

    public static int[] prevSmallerElement(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) stack.pop();
            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    public static int maxAreaRectangle(int[] height) {
        int n = height.length;
        int[] pse = prevSmallerElement(height);
        int[] nse = nextSmallerElement(height);

        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            int x = pse[i];
            int y = nse[i];
            int currArea = (y - x - 1) * height[i];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public static int maxAreaRectangleOptimal(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int idx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height[idx] * (nse - pse - 1));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int idx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, height[idx] * (nse - pse - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        System.out.println(maxAreaRectangle(height));
        System.out.println(maxAreaRectangleOptimal(height));
    }
}
