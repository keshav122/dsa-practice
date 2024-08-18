package com.roadmap.basic_strings;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        String concatString = s.concat(s);
        return (concatString.indexOf(goal) != -1);
    }
}
