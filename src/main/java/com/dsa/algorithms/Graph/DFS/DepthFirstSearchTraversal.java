package com.dsa.algorithms.Graph.DFS;

import java.util.*;

public class DepthFirstSearchTraversal {

    // a node will always go once in a Stack
    // T = O(V + E)
    // S = O(V)
    public static void dfs(List<List<Integer>> graph, int start) {
        int n =  graph.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int i = stack.pop();
            System.out.print(i + " ");

            for (int j : graph.get(i)) {
                if (!visited[j]) {
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(List.of()));      // 0
        graph.add(new ArrayList<>(List.of(2,3)));   // 1
        graph.add(new ArrayList<>(List.of(1,5,6))); // 2
        graph.add(new ArrayList<>(List.of(1,4,7))); // 3
        graph.add(new ArrayList<>(List.of(3,8)));   // 4
        graph.add(new ArrayList<>(List.of(2)));     // 5
        graph.add(new ArrayList<>(List.of(2)));     // 6
        graph.add(new ArrayList<>(List.of(3,8)));   // 7
        graph.add(new ArrayList<>(List.of(4,7)));   // 8

        dfs(graph, 1);
    }
}
