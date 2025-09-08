package com.dsa_series.roadmap.dynamic_programming.dp_on_strings;

public class EditDistance {
    public int editDistance(String start, String target) {
        return f(start.length() - 1, target.length() - 1, start, target);
    }

    private int f(int i, int j, String start, String target) {
        if (i < 0 || j < 0)
            return 0;
        if (start.charAt(i) == target.charAt(j)) {
            return f(i - 1, j - 1, start, target);
        }
        return 1 + Math.min(f(i - 1, j, start, target), f(i - 1, j - 1, start, target));
    }

}
