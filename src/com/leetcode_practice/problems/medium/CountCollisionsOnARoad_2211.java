package com.leetcode_practice.problems.medium;

import java.util.Stack;

public class CountCollisionsOnARoad_2211 {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        st.add(directions.charAt(0));
        for (int i = 1; i < directions.length(); i++) {
            char ch = directions.charAt(i);
            if (st.peek() == 'R' && (ch == 'L' || ch == 'S')) {
                count += (ch == 'L') ? 2 : 1;
                st.pop();
                while (!st.isEmpty() && st.peek() == 'R') {
                    count++;
                    st.pop();
                }
                st.add('S');
            } else if (st.peek() == 'S' && ch == 'L') {
                count++;
            } else {
                st.add(ch);
            }
        }
        return count;
    }

    public int countCollisions_Optimal(String directions) {
        int n = directions.length();
        int i = 0, j = n - 1;
        int collisions = 0;

        // Remove leading L (safe)
        while (i < n && directions.charAt(i) == 'L')
            i++;

        // Remove trailing R (safe)
        while (j >= 0 && directions.charAt(j) == 'R')
            j--;

        // Remaining non-'S' in the middle cause collisions
        for (int k = i; k <= j; k++) {
            if (directions.charAt(k) != 'S')
                collisions++;
        }
        return collisions;
    }
}
