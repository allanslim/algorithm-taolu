package com.allan.algorithm.taolu.exercises;

public class MergedTwoSortedLists {

/**

 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4


 we have to take advantage of the fact that the two list are sorted. we need a result list, and we loop, while l1.next and l2.next
 are not equal to null.

 We also need to consider the end case, that if one of the list is shorter than the other.

*/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void addValueToList(ListNode list, int val) {
        if (list != null) {
            ListNode ptr = list;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new ListNode(val);
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = null;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 == null) {
                if (result == null) {
                    result = new ListNode(l1.val);
                } else {
                    addValueToList(result, l1.val);
                }
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                if (result == null) {
                    result = new ListNode(l2.val);
                } else {
                    addValueToList(result, l2.val);
                }
                l2 = l2.next;
            } else {
                if (l1.val < l2.val) {
                    if (result == null) {
                        result = new ListNode(l1.val);
                    } else {
                        addValueToList(result, l1.val);
                    }
                    l1 = l1.next;
                } else {
                    if (result == null) {
                        result = new ListNode(l2.val);
                    } else {
                        addValueToList(result, l2.val);
                    }
                    l2 = l2.next;
                }
            }
        }
        return result;
    }

    public static void printList(ListNode listNode) {
        ListNode ptr = listNode;
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        addValueToList(l1, 2);
        addValueToList(l1, 4);
        printList(l1);

        ListNode l2 = new ListNode(1);
        addValueToList(l2, 3);
        addValueToList(l2, 4);
        printList(l2);

        ListNode result = mergeTwoLists(l1, l2);
        printList(result);
    }
}
