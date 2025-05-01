package com.roadmap.stacks_and_queues.implementation;

public class StackUsingLL {

    private Node head;
    private int size;

    public StackUsingLL() {
        head = null;
        size = 0;
    }

    public void push(int x) {
        Node element = new Node(x);
        element.next = head;
        head = element;
        size++;

    }

    public int pop() {
        Node temp = head;
        head = head.next;
        return temp.val;
    }

    public int top() {
        return head.val;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}
