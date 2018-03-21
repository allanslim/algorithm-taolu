package com.allan.algorithm.taolu.list;

public  class LinkedListDemo {


    public static void main(String[] args) {
        LinkedList list = new LinkedList(10);
        list.append(9);
        list.append(8);
        list.append(7);
        list.append(6);
        list.append(5);
        list.print();
        list.preprend(11);
        System.out.println(" updated: ");
        list.print();
        list.delete(7);
        System.out.println(" updated: ");
        list.print();
    }
}




