package com.dsa_series.roadmap.beginnerproblems.basic_recursion;

import java.util.Collections;
import java.util.Vector;

public class ReverseString {

    public Vector<Character> reverseStringNonRecursiveWay(Vector<Character> s) {
        Collections.reverse(s);
        return s;
    }

    public Vector<Character> reverseString(Vector<Character> s) {
        if (s.size() <= 1) {
            return s;
        }
        return reverseString(s, 0, s.size() - 1);
    }

    private Vector<Character> reverseString(Vector<Character> s, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            Vector<Character> v = new Vector<>();
            v.add(s.get(startIndex));
            return v;
        }
        Character c = s.get(startIndex);
        Vector<Character> reversedSmallVector = reverseString(s, startIndex + 1, endIndex);
        reversedSmallVector.add(c);
        return reversedSmallVector;
    }
}
