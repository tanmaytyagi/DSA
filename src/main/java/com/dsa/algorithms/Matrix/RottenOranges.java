package com.dsa.algorithms.Matrix;

import java.util.LinkedList;
import java.util.Queue;


// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange

// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// return min time when all oranges become rotten if not possible return -1

public class RottenOranges {

    static class Pair {
        int row;
        int col;
        int time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int minTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                } else if(grid[i][j] == 1) cntFresh++;
            }
        }

        int totalTime = 0;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        int cnt = 0;

        while (!queue.isEmpty()) {
            Pair front = queue.poll();

            int currRow = front.row;
            int currCol = front.col;
            int currTime = front.time;

            totalTime = Math.max(totalTime, currTime);

            for(int i = 0; i < 4; i++) {
                int newRow = currRow + deltaRow[i];
                int newCol = currCol + deltaCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && visited[newRow][newCol] != 1
                        && grid[newRow][newCol] == 1) {

                    queue.add(new Pair(newRow, newCol, currTime + 1));
                    visited[newRow][newCol] = 1;
                    cnt++;
                }
            }
        }

        if(cntFresh != cnt) return -1;
        return totalTime;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(minTime(grid));
    }
}
