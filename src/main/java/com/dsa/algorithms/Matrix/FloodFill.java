package com.dsa.algorithms.Matrix;


/**
 * You are given an image represented by an m x n grid of integers image,
 * where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. Y
 * our task is to perform a flood fill on the image starting from the pixel image[sr][sc].
 */


public class FloodFill {

    public static void func(int[][] image, int i, int j, int color, int[][] visited, int value) {
        int m = image.length;
        int n = image[0].length;

        if(i >= m || i < 0 || j >= n || j < 0) return;
        if(visited[i][j] == 1) return;
        if(image[i][j] != value) return;

        image[i][j] = color;
        visited[i][j] = 1;

        func(image, i + 1, j, color, visited, value);
        func(image, i - 1, j, color, visited, value);
        func(image, i, j + 1, color, visited, value);
        func(image, i, j - 1, color, visited, value);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int[][] visited = new int[m][n];

        int value = image[sr][sc];

        func(image, sr, sc, color, visited, value);

        return image;
    }

    public static void main(String[] args) {

    }
}
