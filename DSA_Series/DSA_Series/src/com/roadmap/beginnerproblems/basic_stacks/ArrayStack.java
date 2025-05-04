/*Author: keshav122 */
package com.roadmap.beginnerproblems.basic_stacks;

public class ArrayStack {
    int[] stack;
    int currPointer;

    public ArrayStack() {
        stack = new int[100];
        currPointer = 0;
    }

    public void push(int x) {
        stack[currPointer] = x;
        currPointer++;
    }

    public int pop() {
        currPointer--;
        return stack[currPointer];
    }

    public int top() {
        return stack[currPointer - 1];
    }

    public boolean isEmpty() {
        if (currPointer == 0 && stack[currPointer] == 0) {
            return true;
        }
        return false;
    }
}
