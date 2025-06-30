package com.dsa_series.roadmap.recursion.implementation_problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(0, 0, n, "", result);
        return result;
    }

    public void generateParenthesis(int leftBraceCount, int rightBraceCount, int n,
            String current, List<String> result) {
        if (leftBraceCount > n) {
            return;
        }
        if (leftBraceCount + rightBraceCount == 2 * n && (leftBraceCount == rightBraceCount)) {
            result.add(current);
            return;
        }

        if (leftBraceCount < n) {
            generateParenthesis(leftBraceCount + 1, rightBraceCount, n, current + "(", result);
        }

        if (rightBraceCount < leftBraceCount) {
            generateParenthesis(leftBraceCount, rightBraceCount + 1, n, current + ")", result);
        }
    }
}
