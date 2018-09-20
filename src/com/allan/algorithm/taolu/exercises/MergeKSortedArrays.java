package com.allan.algorithm.taolu.exercises;


import java.util.PriorityQueue;

public class MergeKSortedArrays {

/**
 *

 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6


 Questions:
 1) are the arrays all in the same length?
 2) can arrays be empty?


 The naive solution is to combine all arrays and sort them. Which will result into O(kn log kn). Where kn is the length
 of the combined array.


but we can do better. so we have this three arrays.

 {1, 4, 5}
 {1, 3, 4}
 {2, 6}

 {1, 1, }

 now if we iterate thru the list, and do a comparison for each of them, and copy the smallest to the new array. But it will be:

 k * n

 it is better than kn log kn but maybe we can do better.

 now let say, if we use a priority queue of length k, and add the first elements. It adding an element in the priority queue,
 will take log (n), and priority queue automatically sorts element as you add them.

 {1, 4, 5}
 {1, 3, 4}
 {2, 6}

 {1,1, 2} = pq

 now, remove the first item from the priority queue and add it to our final result.

 {1, 2} = pq
 {1}

 and then, remove the second element, where you got the first element in the pq.

 {1, 4, 5}

 {1,2,4} = pq
 {1}

 add to a priority queue takes log (n) time.


 runtime would be:

 Time complexity : O(N log k) where k is the number of linked lists.

 The comparison cost will be reduced to O(log k) for every pop and insertion to priority queue.
 But finding the node with the smallest value just costs O(1) time.
 There are N nodes in the final linked list.


 */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode( int x) {val = x;}

        ListNode add(int val) {
            if (next == null) {
                ListNode node = new ListNode(val);
                next = node;
                return next;
            } else {
                ListNode ptr = next;
                while(ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = new ListNode(val);
                return ptr;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(4).add(5);
        ListNode l2 = new ListNode(1);
        l2.add(3).add(4);
        ListNode l3 = new ListNode(2);
        l3.add(6);

        print(l1);
        print(l2);
        print(l3);

        ListNode mergedListNode = mergeSortedList(new ListNode[]{l1, l2, l3});

        print(mergedListNode);

    }

    public static class PriorityQueueElement implements Comparable<PriorityQueueElement> {

        int value;
        ListNode node;

        public PriorityQueueElement(int value, ListNode node) {
            this.value = value;
            this.node = node;
        }

        @Override
        public int compareTo(PriorityQueueElement pq) {
            if(this.value > pq.value) return 1;
            if(this.value < pq.value) return -1;
            return 0;
        }
    }

    public static void add(ListNode listNode, int val) {
        if (listNode.next == null) {
            ListNode node = new ListNode(val);
            listNode.next = node;
        } else {
            ListNode ptr = listNode.next;
            while(ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new ListNode(val);
        }
    }


    private static ListNode mergeSortedList(ListNode[] listNodes) {
        if(listNodes.length == 0) { return null; }

        PriorityQueue<PriorityQueueElement> priorityQueue = new PriorityQueue<>(listNodes.length);
        ListNode result = null;

        for(int i = 0; i < listNodes.length; i++) {
            ListNode ln = listNodes[i];
            if( ln != null) {
                priorityQueue.add(new PriorityQueueElement(ln.val, ln.next));
            }
        }

        while(!priorityQueue.isEmpty()) {
            PriorityQueueElement pqe = priorityQueue.poll();
            if(result == null) {
                result = new ListNode(pqe.value);
            }else {
                add(result, pqe.value);
            }
            if(pqe.node != null ) {
                ListNode nextNode = pqe.node;
                priorityQueue.add(new PriorityQueueElement(nextNode.val, nextNode.next));
            }
        }

        return result;
    }

    public static void print(ListNode node) {
        ListNode ptr = node;
        while(ptr != null) {
            System.out.print(ptr.val + " ->");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

}
