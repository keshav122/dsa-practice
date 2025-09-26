package com.dsa_series.roadmap.strings_advanced_algo.medium_problems;

public class MinimumNumberOfBracketReversalsToMakeExpressionBalanced {
    public int countRev(String s) {
        int n = s.length();
        if (n % 2 != 0)
            return -1;
        int open = 0, close = 0, i = 0;
        while (i < n) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0)
                    open--;
                else
                    close++;
            }
            i++;
        }
        return ((open / 2) + (open % 2) + (close / 2) + (close % 2));
    }
}
