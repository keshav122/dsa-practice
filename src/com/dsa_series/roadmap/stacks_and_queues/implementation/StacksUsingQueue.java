/*Author: keshav122 */
package com.dsa_series.roadmap.stacks_and_queues.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class StacksUsingQueue {
    Queue<Integer> stack;

    public StacksUsingQueue() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        for (int i = 1; i < stack.size(); i++) {
            stack.add(stack.poll());
        }
    }

    public int pop() {
        int val = stack.peek();
        stack.poll();
        return val;
    }

    public int top() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
