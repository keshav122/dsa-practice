package com.roadmap.stacks_and_queues.monotonic_stack;

import java.util.Stack;

public class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> st = new Stack<>();
    for (int asteroid : asteroids) {
      if (asteroid > 0) {
        st.push(asteroid);
      } else {
        int absval = Math.abs(asteroid);
        while (!st.isEmpty() && absval > st.peek()) {
          st.pop();
        }

        if (!st.isEmpty() && absval == st.peek()) {
          st.pop();
          continue;
        }

        if (st.isEmpty()) {
          st.push(asteroid);
        }
      }
    }

    int[] ans = new int[st.size()];
    for (int i = ans.length - 1; i >= 0; i--) {
      ans[i] = st.pop();
    }
    return ans;
  }
}
