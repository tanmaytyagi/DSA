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
}
