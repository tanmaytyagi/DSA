package com.dsa.algorithms.Graph.BFS;

import com.dsa.algorithms.Graph.Vertex.Vertex;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("all")
public class BreadthFirstSearch {

    public static void bsf(Vertex root) {
        Deque<Vertex> deque = new ArrayDeque<>();
        deque.addLast(root); // added

        while (!deque.isEmpty()) {
            Vertex current = deque.pollFirst(); // remove
            System.out.println(current);
            current.setVisited(true);

            for (Vertex v : current.getAdjacencyList()) {
                if(!v.isVisited()) deque.addLast(v); // added
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

        bsf(vertexA);
    }
}
