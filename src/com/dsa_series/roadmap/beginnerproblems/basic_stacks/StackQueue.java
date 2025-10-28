/*Author: keshav122 */
package com.dsa_series.roadmap.beginnerproblems.basic_stacks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Implement a Queue using Stack
public class StackQueue {
    Stack<Integer> stack;

    public StackQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.add(x);
        } else {
            // We will have to add in the reverse order of the input
            List<Integer> temp = new LinkedList<>();
            while (!stack.isEmpty()) {
                temp.add(stack.pop());
            }
            stack.add(x);
            Collections.reverse(temp);
            for (Integer i : temp) {
                stack.add(i);
            }

        }
    }

    public int pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1;
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
