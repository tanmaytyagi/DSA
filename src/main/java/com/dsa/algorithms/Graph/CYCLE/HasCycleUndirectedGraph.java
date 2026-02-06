package com.dsa.algorithms.Graph.CYCLE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// the parent check logic and any traversal (BFS or DFS) can be used to detect cycle

public class HasCycleUndirectedGraph {

    static class Pair {
        int curr;
        int parent;

        public Pair(int value, int parent) {
            this.curr = value;
            this.parent = parent;
        }
    }

    public static boolean hasCycle(List<List<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));

        while(!queue.isEmpty()) {
            Pair front = queue.poll();
            int curr = front.curr;
            int parent = front.parent;

            for(int adj : graph.get(curr)) {
                if(!visited[adj]) {
                    visited[adj] = true;
                    queue.add(new Pair(adj, curr));
                } else if (parent != adj) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(List.of()));      // 0
        graph.add(new ArrayList<>(List.of(2,3)));   // 1
        graph.add(new ArrayList<>(List.of(1,5)));   // 2
        graph.add(new ArrayList<>(List.of(1,4,6))); // 3
        graph.add(new ArrayList<>(List.of(3)));     // 4
        graph.add(new ArrayList<>(List.of(2,7)));   // 5
        graph.add(new ArrayList<>(List.of(3,7)));   // 6
        graph.add(new ArrayList<>(List.of(5,6)));   // 7

        boolean[] visited = new boolean[graph.size()];
        boolean hasCycle = false;

        for(int i = 1 ; i < graph.size() ; i++) {
            if(!visited[i]) hasCycle = hasCycle(graph, i, visited);
        }

        System.out.println(hasCycle);
    }
}
