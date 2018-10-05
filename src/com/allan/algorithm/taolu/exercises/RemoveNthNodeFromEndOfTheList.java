package com.allan.algorithm.taolu.exercises;

public class RemoveNthNodeFromEndOfTheList {

/*

It might be tempting to iterate through the list until we reach the end and then walk backwards k nodes.

But we have a singly linked list! We can’t go backwards. What else can we do?

What if we had the length of the list?

Then we could calculate how far to walk, starting from the head, to reach the kth to last node.

If the list has n nodes:


|---------- n --------|
 1 -> 2 -> 3 -> 4 -> 5


And our target is the kth to last node:


 1 -> 2 -> 3 -> 4 -> 5
           |---k------|

The distance from the head to the target is n−k:


 1 -> 2 -> 3 -> 4 -> 5
|--- n - k ---|


howFarToGo = n - k

We don't know n, but we can figure it out.

Once you identify the node, since you don't have pointer to the previous,
what you can do is to copy the value of the next.

     node.value = node.next.value;

this:

                *
      1 -> 2 -> 3 -> 4 -> 5

will turn into:

                *
      1 -> 2 -> 4 -> 4 -> 5

then, you copy the next's next to the current's next.


                *
      1 -> 2 -> 4 ->  5
                4 ->

And since no one is pointing to that node, it will be garbage collected.


*/
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = new ListNode(5);
//
//        print(a);
//        ListNode result = removeNthFromEnd(a, 2);
//        print(result);

//        ListNode result2 = removeNthFromEnd(new ListNode(1), 1);
//        print(result2);

        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        ListNode result3 = removeNthFromEnd(x, 1);
        print(result3);
    }

    private static void print(ListNode result) {
        ListNode ptr = result;
        while( ptr != null) {
            System.out.print(ptr.val + ", ");
            ptr = ptr.next;
        }
        System.out.println("");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        // STEP 1: get the length of the list
        // start at 1, not 0
        // else we'd fail to count the head node!
        int listLength = 1;
        ListNode ptr = head;

        // traverse the whole list,
        // counting all the nodes
        while(ptr.next != null) {
            ptr = ptr.next;
            listLength++;
        }

        // STEP 2: walk to the target node
        // calculate how far to go, from the head,
        // to get to the kth to last node
        int howFarToGo = listLength - n;
        ptr = head;

        for(int i = 0; i < howFarToGo; i++) {
            ptr = ptr.next;
        }

        if(ptr.next != null) {
            ptr.val = ptr.next.val;
            ptr.next = ptr.next.next;
        } else {
            ptr.next = null;
        }

        return head;
    }

}
