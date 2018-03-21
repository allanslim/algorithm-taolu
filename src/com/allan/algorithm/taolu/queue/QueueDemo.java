package com.allan.algorithm.taolu.queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(5);
        queue.add(4);
        queue.add(3);
        System.out.println("peak: " + queue.peek());
        System.out.println("remove: " + queue.remove());
        System.out.println("peak: " + queue.peek());
    }
}
