package com.dsa_series.roadmap.beginnerproblems.basic_stacks;

import java.util.LinkedList;

public class LinkedListStack {
    LinkedList<Integer> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        int lastIndex = stack.size() - 1;
        if (!stack.isEmpty()) {
            int val = stack.get(lastIndex);
            stack.remove(lastIndex);
            return val;
        }
        return -1;
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
