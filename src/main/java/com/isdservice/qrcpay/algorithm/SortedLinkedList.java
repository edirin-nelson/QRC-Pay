package com.isdservice.qrcpay.algorithm;

public class SortedLinkedList {
    Node head;

    public SortedLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty or the new node's data is less than the head node's data,
        // insert the new node at the beginning of the list.
        if (head == null || data < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            // Traverse the list to find the position to insert the new node.
            while (current.next != null && data >= current.next.data) {
                current = current.next;
            }

            // Insert the new node in the middle or at the end of the list.
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

