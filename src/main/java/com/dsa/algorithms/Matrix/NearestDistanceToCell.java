package com.dsa.algorithms.Matrix;
import java.util.Arrays;

/**
 * Given an
 * m×n
 * binary matrix, mat, find the distance from each cell to the nearest
 * 0
 * . The distance between two adjacent cells is
 * 1
 * . Cells to the left, right, above, and below the current cell will be considered adjacent.
 */
public class NearestDistanceToCell {

    public static void nearestDistanceToCell(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(a[i][j] > 0) {
                    int up = (i > 0) ? a[i-1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? a[i][j-1] : Integer.MAX_VALUE;
                    a[i][j] = Math.min(up, left) + 1;
                }
            }
        }

        for(int i = m-1 ; i >= 0 ; i--) {
            for(int j = n-1 ; j >= 0 ; j--) {
                if(a[i][j] > 0) {
                    int down = (i < m-1) ? a[i+1][j] : Integer.MAX_VALUE - 10000;
                    int right = (j < n-1) ? a[i][j+1] : Integer.MAX_VALUE - 10000;
                    a[i][j] = Math.min(a[i][j], Math.min(down, right) + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1},{1,1}};
        nearestDistanceToCell(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}
