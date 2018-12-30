package com.allan.algorithm.taolu.exercises;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenNestedListIterator {
    /*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,4,6].


The idea here is to store all the data in a queue. And then use the queue to get the next.

Storing the data needs to be recursive, because the "NestedInteger" can be an int or another Nested Integer.


    */

    public static class NestedIterator implements Iterator<Integer> {

        Queue<Integer> queue = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            flatten(nestedList);
        }

        private void flatten(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if(nestedInteger.isInteger()) {
                    queue.offer(nestedInteger.getInteger());
                } else {
                    flatten(nestedInteger.getList());
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            return queue.poll();
        }
    }



    public  interface NestedInteger {
         
                      // @return true if this NestedInteger holds a single integer, rather than a nested list.
                      public boolean isInteger();
         
                      // @return the single integer that this NestedInteger holds, if it holds a single integer
                      // Return null if this NestedInteger holds a nested list
                      public Integer getInteger();
         
                      // @return the nested list that this NestedInteger holds, if it holds a nested list
                      // Return null if this NestedInteger holds a single integer
                      public List<NestedInteger> getList();
    }
}
