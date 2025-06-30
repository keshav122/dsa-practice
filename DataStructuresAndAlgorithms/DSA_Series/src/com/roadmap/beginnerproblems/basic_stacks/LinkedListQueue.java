package com.roadmap.beginnerproblems.basic_stacks;

public class LinkedListQueue {
    Node head;
    Node tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    // This method adds an element to the queue
    public void push(int x) {
        if (head == null) {
            head = new Node(x, null);
            tail = head;
        } else {
            Node temp = new Node(x, null);
            tail.next = temp;
            tail = tail.next;
        }
    }

    // This method removes an element from the front of the queue
    public int pop() {
        if (null != head) {
            int val = head.data;
            head = head.next;
            return val;
        }
        return -1;
    }

    // This method returns the element at the front of the queue without removing it
    public int peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return (head == null);
    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}