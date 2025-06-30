package com.roadmap.beginnerproblems.basic_strings;

import java.util.Vector;

public class ReverseAString {
    public Vector<Character> reverseString(Vector<Character> s) {
        int start = 0;
        int end = s.size() - 1;
        while (start <= end) {
            Character temp = s.get(start);
            s.set(start, s.get(end));
            s.set(end, temp);
            start++;
            end--;
        }
        return s;
    }
}
