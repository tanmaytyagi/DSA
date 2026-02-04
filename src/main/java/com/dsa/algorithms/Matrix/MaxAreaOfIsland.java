package com.dsa.algorithms.Matrix;

public class MaxAreaOfIsland {

    public static int dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) return 0;
        grid[i][j] = 0;

        return 1 + dfs(grid, i + 1, j)
                 + dfs(grid, i - 1, j)
                 + dfs(grid, i, j + 1)
                 + dfs(grid, i, j - 1);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}
