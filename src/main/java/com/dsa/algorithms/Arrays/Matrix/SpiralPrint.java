package com.dsa.algorithms.Arrays.Matrix;

import java.util.Arrays;

/// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral clockwise order.
public class SpiralPrint {

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        int dir = 0, i = 0, j = 0;

        for(int x = 1 ; x <= n * n ; x++) {

            ans[i][j] = x;

            int ni = i + di[dir], nj = j + dj[dir];

            // if next cell is out of bounds or already filled, turn clockwise, as spiral was asked in clockwise
            if(ni < 0 || ni >= n || nj < 0 || nj >= n || ans[ni][nj] != 0) {
                dir = (dir + 1) % 4;
                ni = i + di[dir];
                nj = j + dj[dir];
            }

            i = ni;
            j = nj;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = generateMatrix(10);
        for(int i = 0 ; i < 10 ; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
