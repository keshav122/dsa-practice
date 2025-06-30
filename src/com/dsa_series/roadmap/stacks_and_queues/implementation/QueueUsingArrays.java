package com.dsa_series.roadmap.stacks_and_queues.implementation;

class ArrayQueue {
    int[] q;
    int start, end, currSize;

    public ArrayQueue() {
        q = new int[100];
        start = end = -1;
        currSize = 0;
    }

    public void push(int x) {
        if (start == -1 && end == -1) {
            start++;
        }
        end++;
        q[end % q.length] = x;
        currSize++;
    }

    public int pop() {
        int value = q[start];
        start++;
        currSize--;
        return value;
    }

    public int peek() {
        return q[start];
    }

    public boolean isEmpty() {
        return (currSize == 0);
    }
}

public class QueueUsingArrays {
    int[] q;
    int start, end, currSize;

    public QueueUsingArrays() {
        q = new int[100];
        start = end = -1;
        currSize = 0;
    }

    public void push(int x) {
        if (start == -1 && end == -1) {
            start++;
        }
        end++;
        q[end % q.length] = x;
        currSize++;
    }

    public int pop() {
        int value = q[start];
        if (currSize == 1) {
            start = end = -1;
        } else {
            start = (start + 1) % q.length;
        }

        currSize--;
        return value;
    }

    public int peek() {
        return q[start];
    }

    public boolean isEmpty() {
        return (currSize == 0);
    }
}
