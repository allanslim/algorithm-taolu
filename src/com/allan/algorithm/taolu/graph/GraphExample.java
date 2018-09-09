package com.allan.algorithm.taolu.graph;

public class GraphExample {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.getOrCreateNode(1);
        graph.getOrCreateNode(3);
        graph.addEdge(1, 3);
        graph.getOrCreateNode(4);
        graph.addEdge(1, 4);
        graph.getOrCreateNode(5);
        graph.addEdge(1, 5);
        graph.addEdge(3, 5);
        graph.getOrCreateNode(6);
        graph.addEdge(5, 6);

        System.out.println(" is there a path from 1 to 6? " + graph.hasPathDFS(1, 6));
        System.out.println(" is there a path from 1 to 6? " + graph.hasPathBFS(1, 6));
    }
}
