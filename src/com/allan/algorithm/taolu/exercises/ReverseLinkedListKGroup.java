package com.allan.algorithm.taolu.exercises;

public class ReverseLinkedListKGroup {

    public static class LinkedListNode {
        public int value;
        public LinkedListNode next;
        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static class LinkedList {
        public LinkedListNode head;

        public void add(int value) {
            if(this.head == null) {
                this.head = new LinkedListNode(value);
                return;
            }
            LinkedListNode current = this.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new LinkedListNode(value);
        }

        public void print() {
            LinkedListNode current = this.head;
            while(current != null) {
                System.out.print(current.value + "-");
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.print();
        LinkedList reversedKGroupList = reverseKGroup(linkedList, 2);
        System.out.println("---- reversed -----");
        reversedKGroupList.print();

    }


    public static LinkedList reverseKGroup(LinkedList list, int k) {
        LinkedList reversedList = new LinkedList();
        reversedList.head = swapInAGroup(list.head, k);
        return reversedList;
    }

    public static LinkedListNode swapInAGroup(LinkedListNode head, int k) {

        if(head == null) {
            return null;
        }

        LinkedListNode p;

        // Go to the kth node
        p = head;
        int count = 0;
        while (count != k - 1) {
            if (p.next == null) {
                return head;
            }
            p = p.next;
            count++;
        }

        LinkedListNode newStart = p;
        LinkedListNode temp;
        LinkedListNode q = newStart;
        while (true) {
            p = head;
            temp = q.next;
            //
            // in the case of:
            // p     newStart      temp
            // 1 ->  2   ---------> null
            //
            if (temp == null) {
                reverse(p);
                return newStart;
            }
            //
            //  head,p        newStart,q         temp
            //    1-----------> 2---------------->3  -> 4 --> 5
            //
            //
            q.next = null;
            q = temp;
            head = temp;
            count = 0;  // reset counter

            // move temp, to the kth of the next group:
            //
            //   p      newStart              temp,q,head
            //   1 -------> 2 ------>null       3 ----------> 4 ---> 5
            //
            while (count != k - 1) {
                // if temp == null, reverse return newStart"
                //
                //  p      newStart              temp,q,head
                //  1 --------> 2 ------> null      3  ---> null

                if (temp.next == null) {
                    reverse(p);
                    p.next = q;
                    return newStart;
                }
                temp = temp.next;
                count++;
            }

            //
            // reverse p:
            //
            //   p      newStart               q,head                  temp
            //   1 <---------2<------------------3 --------> 4 ----------> 5
            //
            //  p.next = temp:
            //
            //        temp       p         newStart           head,q
            //  4 ---> 5   <---- 1 <-----------2<----------------3
            //
            //   q = temp:
            //
            //           temp,q            p             newStart             head
            //    4 ---> 5 <---------------1 <------------ 2 <---------------- 3
            //
            reverse(p);
            p.next = temp;
            q = temp;
        }
    }

    public static void reverse(LinkedListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        reverse(head.next);
        head.next.next = head;
        head.next = null;
    }
}
