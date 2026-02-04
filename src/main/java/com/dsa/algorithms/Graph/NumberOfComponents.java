package com.dsa.algorithms.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("all")
public class NumberOfComponents {

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int start) {
        int n =  graph.size();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (int j : graph.get(i)) {
                if (!visited[j]) {
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }


    public static int numberOfComponents(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];

        int ans = 0;

        for(int i = 1 ; i < n ; i++) {
            if(!visited[i]) {
                dfs(graph, visited, i);
                ans++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        // Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(List.of()));      // 0
        graph.add(new ArrayList<>(List.of(2)));     // 1
        graph.add(new ArrayList<>(List.of(1,3)));   // 2
        graph.add(new ArrayList<>(List.of(2)));     // 3
        graph.add(new ArrayList<>(List.of(5)));     // 4
        graph.add(new ArrayList<>(List.of(4,6)));   // 5
        graph.add(new ArrayList<>(List.of(5)));     // 6
        graph.add(new ArrayList<>(List.of(8)));     // 7
        graph.add(new ArrayList<>(List.of(7)));     // 8

        System.out.println(numberOfComponents(graph));
    }
}
