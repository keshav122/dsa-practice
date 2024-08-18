package com.roadmap.basic_recursion;

import java.util.Vector;

public class ReverseString {
    public Vector<Character> reverseString(Vector<Character> s) {
        if (s.size() <= 1) {
            return s;
        }
        return reverseString(s, 0, s.size() - 1);
    }

    private Vector<Character> reverseString(Vector<Character> s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return s;
        }
        Character c = s.get(startIndex);
        Vector<Character> reversedSmallVector = reverseString(s, startIndex + 1, endIndex - 1);
        reversedSmallVector.set(endIndex, c);
        return reversedSmallVector;
    }
}
