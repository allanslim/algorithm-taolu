package com.allan.algorithm.taolu.graph;

import java.util.*;

public class Graph {
    private Map<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        public int id;
        List<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    public Node getOrCreateNode(int id) {
        if (!nodeLookup.containsKey(id)) {
            Node newNode = new Node(id);
            nodeLookup.put(id, newNode);
        }
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
        Node sourceNode = getOrCreateNode(source);
        Node destinationNode = getOrCreateNode(destination);
        sourceNode.adjacent.add(destinationNode);
    }

    public boolean hasPathDFS(int source, int destination) {

        Node sourceNode = getOrCreateNode(source);
        Node destinationNode = getOrCreateNode(destination);

        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(sourceNode, destinationNode, visited);
    }

    private boolean hasPathDFS(Node sourceNode, Node destinationNode, Set<Integer> visited) {
        if (visited.contains(sourceNode.id)) {
            return false;
        }

        visited.add(sourceNode.id);

        if (sourceNode == destinationNode) {
            return true;
        }

        for (Node child : sourceNode.adjacent) {
            if (hasPathDFS(child, destinationNode, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {

        Node sourceNode = getOrCreateNode(source);
        Node destinationNode = getOrCreateNode(destination);

        LinkedList<Node> nextToVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        nextToVisit.add(sourceNode);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node == destinationNode) {
                return true;
            }

            if (visited.contains(node.id)) {
                continue;
            }

            visited.add(node.id);

            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
