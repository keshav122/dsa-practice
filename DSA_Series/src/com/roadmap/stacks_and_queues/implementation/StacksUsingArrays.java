package com.roadmap.stacks_and_queues.implementation;

public class StacksUsingArrays {
    int[] st;
    int top;

    public StacksUsingArrays() {
        st = new int[100];
        top = -1;
    }

    public void push(int x) {
        if (top > 100) {
            System.out.println("Exceeding array bounds");
        }
        top++;
        st[top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        return st[top--];
    }

    public int top() {
        if (top == -1) {
            return -1;
        }
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
