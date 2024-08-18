package com.roadmap.beginnerproblems.basic_stacks;

public class ArrayQueue {
  int[] queue;
  int start;
  int end;

  public ArrayQueue() {
    queue = new int[100];
    start = end = 0;
  }

  public void push(int x) {
    queue[end] = x;
    end++;
  }

  public int pop() {
    if (!isEmpty()) {
      int val = queue[start];
      start++;
      return val;
    }
    return -1;
  }

  public int peek() {
    if (!isEmpty()) {
      return queue[start];
    }
    return -1;
  }

  public boolean isEmpty() {
    return (end != 0 && start <= end);
  }
}
