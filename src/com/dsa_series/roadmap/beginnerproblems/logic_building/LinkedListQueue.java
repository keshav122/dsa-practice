package com.dsa_series.roadmap.beginnerproblems.logic_building;

import java.util.LinkedList;

/*Implement a Queue using a Linked List */
public class LinkedListQueue {
    LinkedList<Integer> queue;

    public LinkedListQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return queue.removeFirst();
    }

    public int peek() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return (queue.size() == 0);
    }
}

// Without using the OOTB LinkedList
class LinkedListQueue_2 {
    Node head;
    Node tail;

    public LinkedListQueue_2() {
        head = null;
        tail = null;
    }

    // This method adds a element to the queue
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

    // This method removes a element from the front of the queue
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