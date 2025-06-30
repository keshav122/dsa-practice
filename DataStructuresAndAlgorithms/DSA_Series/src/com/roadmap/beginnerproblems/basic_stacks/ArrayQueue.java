package com.roadmap.beginnerproblems.basic_stacks;

public class ArrayQueue {
  int[] queue;

  int entry; // The index at which a new element can be inserted
  int release;// The index from where the element can be released

  public ArrayQueue() {
    queue = new int[100];
    release = entry = queue.length - 1;
  }

  public void push(int x) {
    queue[entry] = x;
    entry--;
  }

  public int pop() {
    int val = queue[release];
    release--;
    return val;
  }

  public int peek() {
    if (!isEmpty()) {
      return queue[release];
    }
    return -1;
  }

  public boolean isEmpty() {
    return (entry == release);
  }
}
