package com.isdservice.qrcpay.algorithm;

public class Main {
    /*

    1. Create a Node class to represent the elements in the linked list.
    2. Traverse the list to find the appropriate position to insert the new node while maintaining the sorting order.
    3. Insert the new node at the correct position.

     */
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(7);
        list.insert(3);
        list.insert(15);

        list.display(); // Output: 3 5 7 10 15
    }
}