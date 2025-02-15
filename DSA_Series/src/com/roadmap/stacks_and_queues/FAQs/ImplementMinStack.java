package com.roadmap.stacks_and_queues.FAQs;

import java.util.Stack;

public class ImplementMinStack {
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;

    public ImplementMinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            min = val;
            st.push(val);
            return;
        }

        if (val > min)
            st.push(val);
        else {
            st.push((2 * val) - min);
            min = val;
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;
        int x = st.pop();
        if (x < min) {
            min = 2 * min - x;
        }
    }

    public int top() {
        if (st.isEmpty())
            return -1;
        int x = st.peek();
        if (x < min) {
            return min;
        }
        return x;
    }

    public int getMin() {
        return min;
    }
}

class MinStack {
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair(val, val));
        } else {
            st.push(new Pair(val, Math.min(st.peek().second, val)));
        }

    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().first;
    }

    public int getMin() {
        return st.peek().second;
    }
}

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class ImplementMinStack_BF {
    Stack<Integer> st;
    int minVal;

    public ImplementMinStack_BF() {
        st = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        minVal = Math.min(minVal, val);
        st.push(val);
    }

    public void pop() {
        int value = st.pop();
        if (value == minVal) {
            minVal = Integer.MAX_VALUE;
            Stack<Integer> temp = new Stack<>();
            while (!st.isEmpty()) {
                minVal = Math.min(minVal, st.peek());
                temp.add(st.pop());
            }
            while (!temp.isEmpty()) {
                st.add(temp.pop());
            }
        }

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minVal;
    }
}
