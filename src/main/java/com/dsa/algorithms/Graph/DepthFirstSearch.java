package com.dsa.algorithms.Graph;

import java.util.Stack;

@SuppressWarnings("all")
public class DepthFirstSearch {

    // recursive (most common)
    public static void dfs(Vertex root) {
        root.setVisited(true);
        System.out.println(root);

        for(Vertex v : root.getAdjacencyList()) {
            if(!v.isVisited()) dfs(v);
        }
    }

    // stack based implementation
    public static void dfs2(Vertex root) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            current.setVisited(true);
            System.out.println(current);
            for(Vertex v : current.getAdjacencyList()) {
                if(!v.isVisited()) stack.push(v);
            }
        }
    }

    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");
        Vertex vertexG = new Vertex("G");
        Vertex vertexH = new Vertex("H");

        vertexA.addNeighbour(vertexB);
        vertexA.addNeighbour(vertexF);
        vertexA.addNeighbour(vertexG);

        vertexB.addNeighbour(vertexA);
        vertexB.addNeighbour(vertexC);
        vertexB.addNeighbour(vertexD);

        vertexC.addNeighbour(vertexB);

        vertexD.addNeighbour(vertexB);
        vertexD.addNeighbour(vertexE);

        vertexF.addNeighbour(vertexA);

        vertexG.addNeighbour(vertexA);
        vertexG.addNeighbour(vertexH);

        vertexH.addNeighbour(vertexG);

        dfs2(vertexA);
    }
}
