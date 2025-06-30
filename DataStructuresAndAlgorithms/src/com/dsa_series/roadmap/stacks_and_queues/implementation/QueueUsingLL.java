/*Author: keshav122 */
package com.roadmap.stacks_and_queues.implementation;

public class QueueUsingLL {

    Node start;
    Node end;
    int size = 0;

    public QueueUsingLL() {
        start = end = null;
    }

    public void push(int x) {
        Node temp = new Node(x);
        if (start == null) {
            start = end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
        size++;
    }

    public int pop() {
        Node temp = start;
        start = start.next;
        size--;
        return temp.data;
    }

    public int peek() {
        return start.data;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}