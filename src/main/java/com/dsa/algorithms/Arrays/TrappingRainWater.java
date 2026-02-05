package com.dsa.algorithms.Arrays;

public class TrappingRainWater {

    // keeping track of leftMax and rightMax for all index
    public static int maxRainWaterTrapped(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = -1;
        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        rightMax[height.length-1] = -1;
        for(int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }

        int totalWaterTrapped = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] < leftMax[i] &&  height[i] < rightMax[i]) {
                totalWaterTrapped += (leftMax[i] < rightMax[i]) ?
                        leftMax[i] - height[i] : rightMax[i] - height[i];
            }
        }

        return totalWaterTrapped;
    }


    // two pointer approach
    public static int maxRainWaterTrappedOptimal(int[] height) {
        int n =  height.length;
        int i = 0;
        int j = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWaterTrapped = 0;

        while(i < j) {
            // move the pointer from smaller height

            if(height[i] < height[j]) {
                if(leftMax < height[i]) {
                    leftMax = height[i];
                } else {
                    totalWaterTrapped += leftMax - height[i];
                }
                i++;
            } else {
                if(rightMax < height[j]) {
                    rightMax = height[j];
                } else {
                    totalWaterTrapped += rightMax - height[j];
                }
                j--;
            }
        }

        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(maxRainWaterTrapped(height));
        System.out.println(maxRainWaterTrappedOptimal(height));
    }
}
