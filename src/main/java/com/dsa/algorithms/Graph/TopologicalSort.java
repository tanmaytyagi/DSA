package com.dsa.algorithms.Graph;
import java.util.List;
import java.util.Stack;

import static com.dsa.algorithms.Graph.Vertex.createDAG;


public class TopologicalSort {

    public static final Stack<Vertex> stack = new Stack<>();

    public static void dfs(Vertex vertex) {
        vertex.setVisited(true);
        for (Vertex v : vertex.getAdjacencyList()) if(!v.isVisited()) dfs(v);
        stack.push(vertex);
    }

    public static void topologicalSort(List<Vertex> vertices) {
        for(Vertex v : vertices) if(!v.isVisited()) dfs(v);
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            System.out.println(current);
        }
    }

    public static void main(String[] args) {
        List<Vertex> vertexList = createDAG();
        topologicalSort(vertexList);
    }
}
