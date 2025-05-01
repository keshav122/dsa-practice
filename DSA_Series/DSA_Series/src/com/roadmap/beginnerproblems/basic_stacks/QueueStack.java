package com.roadmap.beginnerproblems.basic_stacks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueStack {
    Queue<Integer> queue;

    public QueueStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        if (queue.isEmpty()) {
            queue.add(x);
        } else {
            // We will have to add in the reverse order of the input
            List<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                temp.add(queue.poll());
            }
            queue.add(x);
            for (Integer i : temp) {
                queue.add(i);
            }

        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
