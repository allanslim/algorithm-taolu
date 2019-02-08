package com.allan.algorithm.taolu.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCluster {

    static class Node {
        char value;
        Node next;


        public Node(char value) {
            this.value = value;
            this.next = null;
        }

        public void add(char value) {
            Node current = new Node(value);
            if(this.next == null) {
                this.next = current;
            } else {
                Node pointer = this.next;
                while( pointer.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = current;
            }
        }

        public void print() {
            System.out.print(this.value);
            Node pointer = this.next;
            while( pointer != null) {
                System.out.print("->" + pointer.value);
                pointer = pointer.next;
            }
        }
    }

    public static void main(String[] args) {
        Node list = new Node('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        list.add('g');
        list.add('h');
        list.add('i');
        list.add('j');
        list.add('k');

        Node[] random = {new Node('i'), new Node('k'), new Node('a'), new Node('j'), new Node('b')};

        int cluster = getClusters(random, list);

        System.out.println(cluster); // 2

        cluster = getClusters(new Node[]{new Node('a'),new Node('b'), new Node('e'), new Node('f'), new Node('j'), new Node('k')}, list);

        System.out.println(cluster); // 3

    }

    private static int getClusters(Node[] randomNodes, Node list) {
        Map<Character, Integer> nodeToIndex = new HashMap<>();

        Node pointer = list;
        int counter = 0;
        while (pointer != null) {
            nodeToIndex.put(pointer.value, counter++);
            pointer = pointer.next;
        }

        List<Integer> indexes = new ArrayList<>();
        for (Node node: randomNodes) {
            Integer index = nodeToIndex.get(node.value);
            indexes.add(index);
        }
        Collections.sort(indexes);

        int cluster = 0;
        for(int i = 0; i < indexes.size() - 1; i++) {
            if( indexes.get(i) + 1 != indexes.get(i + 1)) {
                cluster++;
            }
        }
        cluster++;
        return cluster;
    }
}