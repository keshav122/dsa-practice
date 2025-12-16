/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        char[] wordArr = word.toCharArray();
        boolean firstChar = Character.isUpperCase(wordArr[0]);

        if (firstChar) {
            boolean secondChar = Character.isUpperCase(wordArr[1]);
            if (secondChar) {
                for (int i = 2; i < wordArr.length; i++) {
                    if (!Character.isUpperCase(wordArr[i]))
                        return false;
                }
                return true;
            } else {
                return !upperCasePresent(wordArr, 2);
            }
        } else {
            return !upperCasePresent(wordArr, 1);
        }
    }

    private boolean upperCasePresent(char[] arr, int startingIndex) {
        for (int i = startingIndex; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i]))
                return true;
        }
        return false;
    }

    // Time Expensive but cleaner
    public boolean detectCapitalUseCleaner(String word) {
        if (word.equals(word.toUpperCase()))
            return true;

        if (word.equals(word.toLowerCase()))
            return true;

        String rest = word.substring(1);
        return Character.isUpperCase(word.charAt(0)) && rest.equals(rest.toLowerCase());
    }

    public boolean detectCapitalUseCleaner1(String word) {
        int upperCaseCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            }
        }
        return upperCaseCount == 0 || upperCaseCount == word.length()
                || (upperCaseCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
