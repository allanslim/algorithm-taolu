package com.allan.algorithm.taolu.exercises.lexicographical;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * # PROMPT:
 * #
 * # You're given a list of words which are lexicographically (i.e. alphabetically) sorted.
 * # Write a function which prints the lexicographic order of the characters.
 * # Note: won't be the same as the Roman alphabet.
 * <p>
 * # input:
 * # words = [
 * # "one",
 * # "son",
 * # "soon",
 * # "eon"]
 * <p>
 * # Diagramming
 * <p>
 * # adjacency list --> create a graph
 * <p>
 * # l
 * # one
 * <p>
 * # son
 * <p>
 * # ["o", "s"]
 * <p>
 * #   l
 * # son
 * # soon
 * <p>
 * # ["n", "o"]
 * <p>
 * # l
 * # soon
 * # eon
 * <p>
 * # ["s", "e"]
 * <p>
 * # words = [
 * # "ons",
 * # "one",
 * # "son",
 * # "soon",
 * # "face"
 * # "eon"]
 * <p>
 * #   n     f       # f is pointing to e
 * #   |     ^  \    # ["n", "o", "s", "f", "e"]
 * #   v     |   \
 * #  o --> s --> e
 * <p>
 * # perform topological sort?
 * <p>
 * <p>
 * # visited = {"f", "e", "n", "o", "s"}
 * # call stack = []
 * # result = ["e", "f", "s", "o", "n"]
 * # reverse = ["n", "o", "s", "f", "e"]
 * <p>
 * # output: ["n", "o", "s", "e"]
 * <p>
 * # GRAPH
 *
 *
 *
 *  Solution:
 *
 *  1) get the first two words from the list.
 *
 *     one
 *     son
 *
 *  2) get the first two character that are not equal, return it s a tuple or a list
 *
 *    o,s
 *
 * 3) add them in a graph.
 *
 *   o->s
 *
 *  4) repeat until all the words are added in the graph.
 *
 *   o -> s
 *   n -> o
 *   s -> e
 *
 *   5) do a DFS read in the graph. (keeping track of visited).
 *
 *   e -> s -> o -> n
 *
 *   6) reverse the result
 *
 *   n -> o -> s -> e
 */

public class LexicographicalOrder {

    public static void main(String[] args) {
        Graph graph = new Graph();

        List<String> words = new ArrayList<>();
        words.add("one");
        words.add("son");
        words.add("soon");
        words.add("eon");

        System.out.println(lexicographicalOrder(words, graph));
    }

    private static List<String> lexicographicalOrder(List<String> words, Graph graph) {
        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);
            String nextWord = words.get(i + 1);

            List<String> firstLetterDifference = extractFirstLetterDifferenceInOrder(word, nextWord);

            if (!firstLetterDifference.isEmpty()) {
                graph.getOrCreateNode(firstLetterDifference.get(0));
                graph.getOrCreateNode(firstLetterDifference.get(1));
                graph.addEdge(firstLetterDifference.get(0), firstLetterDifference.get(1));
            }
        }
        return topologicalSort(graph);
    }

    private static List<String> topologicalSort(Graph graph) {
        Set<String> visited = new HashSet<>();
        List<String> result = new LinkedList<>();
        for (Graph.Node node : graph.nodeLookup.values()) {
            dfs(node, visited, result);
        }
        Collections.reverse(result);
        return result;
    }

    private static void dfs(Graph.Node node, Set<String> visited, List<String> result) {
        if (visited.contains(node.id)) {
            return;
        }
        visited.add(node.id);
        List<Graph.Node> neighbors = node.adjacent;
        for (Graph.Node neighbor : neighbors) {
            dfs(neighbor, visited, result);
        }
        result.add(node.id);
    }

    private static List<String> extractFirstLetterDifferenceInOrder(String word, String nextWord) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(word.length(), nextWord.length()); i++) {
            if (word.charAt(i) != nextWord.charAt(i)) {
                result.add(String.valueOf(word.charAt(i)));
                result.add(String.valueOf(nextWord.charAt(i)));
                return result;
            }
        }
        return result;
    }
}
