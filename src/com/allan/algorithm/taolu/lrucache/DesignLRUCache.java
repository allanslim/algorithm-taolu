package com.allan.algorithm.taolu.lrucache;

import java.util.HashMap;
import java.util.Map;

public class DesignLRUCache {

    static class Node {
        String key;
        String value;
        Node previous, next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            previous = null;
            next = null;
        }
    }

    static class LRUCache {
        int capacity, count;
        Node head;
        Node tail;
        Map<String, Node> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = null;
            this.tail = null;
            cache = new HashMap<>(capacity);
        }

        public void put(String key, String value) {
            if (!cache.containsKey(key)) {
                Node current = new Node(key, value);
                addNode(current);
                cache.put(key, current);
                count++;
            } else {
                Node current = cache.get(key);
                current.key = key;
                current.value = value;
                moveToHead(current);
            }

            if (count > capacity) {
                this.removeFromTail();
            }
        }

        public String get(String key) {
            if (this.cache.containsKey(key)) {
                Node current = this.cache.get(key);
                moveToHead(current);
                return current.value;
            }
            return null;
        }

        private void removeFromTail() {
            if (tail != null) {
                tail = tail.previous;
                tail.next = null;
            }
        }

        private void moveToHead(Node current) {
            removeNode(current);
            addNode(current);
        }

        private void removeNode(Node current) {
            Node previousNode = current.previous;
            Node nextNode = current.next;

            if (previousNode != null) {
                previousNode.next = nextNode;
            }

            if (nextNode != null) {
                nextNode.previous = previousNode;
            }

            if (head == current) {
                head = nextNode;
            }

            if (tail == current) {
                tail = previousNode;
            }
        }

        private void addNode(Node current) {
            current.next = head;
            current.previous = null;

            if (head != null) {
                head.previous = current;
            }

            head = current;

            if (tail == null) {
                tail = current;
            }
        }

        public void print() {
            Node current = head;
            while (current != null) {
                System.out.print("[" + current.value + "]->");
                current = current.next;
            }
            System.out.println("");
            System.out.println("head -> " + head.value + " and tail ->" + tail.value);
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("ceo", "John");
        lruCache.put("cto", "George");
        lruCache.put("cfo", "Ringo");
        //lruCache.print();
        System.out.println(" the CFO is: " + lruCache.get("cfo"));
        //lruCache.print();
        System.out.println(" the CFO is: " + lruCache.get("ceo"));
        //lruCache.print();
        System.out.println(" the CFO is: " + lruCache.get("cto"));
        lruCache.print();
        lruCache.put("director", "Paul");
        lruCache.print();
        lruCache.put("manager", "Clapton");
        lruCache.print();
    }
}
