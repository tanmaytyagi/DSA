package com.dsa.algorithms.Graph.Vertex;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        visited = false;
        adjacencyList = new ArrayList<>();
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNeighbour(Vertex vertex) {
        adjacencyList.add(vertex);
    }

    @Override
    public String toString() {
        return name;
    }


    /**
     *         C
     *         ^
     *         |
     *         B ----> D ----> E
     *         ^
     *         |
     *         A
     *       /   \
     *      v     v
     *      F     G <---- H
     */

    public static List<Vertex> createDAG() {
        List<Vertex> graph = new ArrayList<>();
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

        vertexB.addNeighbour(vertexC);
        vertexB.addNeighbour(vertexD);

        vertexD.addNeighbour(vertexE);

        vertexH.addNeighbour(vertexG);

        graph.add(vertexA);
        graph.add(vertexB);
        graph.add(vertexC);
        graph.add(vertexD);
        graph.add(vertexE);
        graph.add(vertexF);
        graph.add(vertexG);
        graph.add(vertexH);
        return graph;
    }
}
