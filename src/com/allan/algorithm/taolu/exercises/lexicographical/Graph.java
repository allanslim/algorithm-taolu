package com.allan.algorithm.taolu.exercises.lexicographical;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    public static class Node {
        public String id;
        public List<Node> adjacent = new LinkedList<>();
        private Node(String id) {
            this.id = id;
        }
    }

    public Map<String, Node> nodeLookup = new HashMap<>();


    public Node getOrCreateNode(String id) {
        if (!nodeLookup.containsKey(id)) {
            Node newNode = new Node(id);
            nodeLookup.put(id, newNode);
        }
        return nodeLookup.get(id);
    }

    public void addEdge(String source, String destination) {
        Node sourceNode = getOrCreateNode(source);
        Node destinationNode = getOrCreateNode(destination);
        sourceNode.adjacent.add(destinationNode);
    }

}