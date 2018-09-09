package com.allan.algorithm.taolu.exercises.farmville;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*


We are using a heap to analyze the sequence of actions that take place in popular game, Farmville.
Users can do the following five actions: buy seeds, harvest crops, build barn, sell produce and buy chickens.
Let's say we recognize the following user patterns:

Buy Seeds --> Harvest Crops --> Sell Produce
Buy Seeds
Build Barn --> Build Barn --> Buy Chickens
Build Barn
We deduce that it is possible to Harvest Crops right after Buy Seeds and it is possible to Sell Produce right after Harvest Crops.

Write an algorithm that takes in the user flows, and determines an appropriate sequence of events that are plausible.

Input, is an array of arrays of user flows.

Input: Array of Array of Strings, [[String]]
Output: Array of Strings [String]

Examples
Example 1:
Input1:
[["Buy Seeds","Harvest Crops", "Sell Produce"], ["Sell Produce", "Buy Chickens"],
 ["Sell Produce, Build Barn"], ["Build Barn", "Buy Chickens"]]

Output1:
["Buy Seeds", "Harvest Crops", "Sell Produce", "Build Barn", "Buy Chickens"]



Solution:
1. Create a graph based on the recognized pattern.
2. Loop through each event in the input
3. Do a DFS Search in each input

 */
public class FarmvilleActivityAnalyzer {

    public static void main(String[] args) {
        Graph graph = createGraphBasedOnRecognizedPattern();

        List<List<String>> input = new ArrayList<>();
        input.add(createEvent("Buy Seeds", "Harvest Crops", "Sell Produce"));
        input.add(createEvent("Sell Produce", "Buy Chickens"));
        input.add(createEvent("Sell Produce", "Build Barn"));
        input.add(createEvent("Build Barn", "Buy Chickens"));

        List<String> output = analyzeActivity(input, graph);

        for (String event : output) {
            System.out.println(event);
        }
    }

    private static Graph createGraphBasedOnRecognizedPattern() {
        Graph graph = new Graph();
        graph.getOrCreateNode("Buy Seeds");
        graph.getOrCreateNode("Harvest Crops");
        graph.getOrCreateNode("Sell Produce");
        graph.addEdge("Buy Seeds", "Harvest Crops");
        graph.addEdge("Harvest Crops", "Sell Produce");
        graph.getOrCreateNode("Build Barn");
        graph.getOrCreateNode("Buy Chickens");
        graph.addEdge("Build Barn", "Buy Chickens");
        return graph;
    }

    private static List<String> analyzeActivity(List<List<String>> input, Graph graph) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (List<String> events : input) {
            for (String event : events) {
                dfs(event, graph, visited, result);
            }
        }

        Collections.reverse(result);
        return result;
    }

    private static void dfs(String event, Graph graph, Set<String> visited, List<String> result) {
        if (visited.contains(event)) {
            return;
        }
        visited.add(event);
        GraphNode graphNode = graph.getOrCreateNode(event);
        for (GraphNode adjacentNode : graphNode.adjacent) {
            dfs(adjacentNode.id, graph, visited, result);
        }
        result.add(event);
    }


    public static class GraphNode {
        String id;
        List<GraphNode> adjacent = new ArrayList<>();

        public GraphNode(String id) {
            this.id = id;
        }
    }

    public static class Graph {
        Map<String, GraphNode> nodeLookUp = new HashMap<>();

        public GraphNode getOrCreateNode(String value) {
            if (!nodeLookUp.containsKey(value)) {
                GraphNode node = new GraphNode(value);
                nodeLookUp.put(value, node);
                return node;

            }
            return nodeLookUp.get(value);
        }

        public void addEdge(String source, String destination) {
            GraphNode sourceNode = getOrCreateNode(source);
            GraphNode destinationNode = getOrCreateNode(destination);
            sourceNode.adjacent.add(destinationNode);
        }
    }

    private static List<String> createEvent(String... eventArgs) {
        List<String> events = new ArrayList<>();
        for (String event : eventArgs) {
            events.add(event);
        }
        return events;
    }
}
