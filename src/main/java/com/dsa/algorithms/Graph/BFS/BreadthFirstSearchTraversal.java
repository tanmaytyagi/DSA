package com.dsa.algorithms.Graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchTraversal {

    // a node will always go once in a Queue
    // T = O(V + E)
    // S = O(V)
    public static void bfs(List<List<Integer>> graph, int start) {
        int n =  graph.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i + " ");

            for (int j : graph.get(i)) {
                if (!visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(List.of()));      // 0
        graph.add(new ArrayList<>(List.of(2,6)));   // 1
        graph.add(new ArrayList<>(List.of(1,3,4))); // 2
        graph.add(new ArrayList<>(List.of(2)));     // 3
        graph.add(new ArrayList<>(List.of(2,5)));   // 4
        graph.add(new ArrayList<>(List.of(4,8)));   // 5
        graph.add(new ArrayList<>(List.of(1,7,9))); // 6
        graph.add(new ArrayList<>(List.of(6,8)));   // 7
        graph.add(new ArrayList<>(List.of(5,7)));   // 8
        graph.add(new ArrayList<>(List.of(6)));     // 9

        bfs(graph,6);
    }
}
