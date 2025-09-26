package com.dsa_series.roadmap.strings_advanced_algo.medium_problems;

import java.util.ArrayList;
import java.util.List;

public class ReverseEveryWordInString {
    public String reverseWords_BF(String s) {
        List<String> words = new ArrayList<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            // find first character
            while (i < n && s.charAt(i) == ' ')
                i++;
            if (i >= n)
                break;
            int start = i;
            // find end index
            while (i < n && s.charAt(i) != ' ')
                i++;
            int end = i;
            words.add(s.substring(start, end));
        }

        String res = "";
        for (int j = words.size() - 1; j >= 0; j--) {
            res += words.get(j);
            if (j != 0)
                res += " ";
        }
        return res;
    }

    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        int i = 0, j = 0, start = 0, end = 0;
        while (j < n) {
            while (j < n && sb.charAt(j) == ' ')
                j++;
            if (j == n)
                break;

            start = i;
            // Copy the word characters forward
            while (j < n && sb.charAt(j) != ' ') {
                if (i < sb.length()) {
                    sb.setCharAt(i++, sb.charAt(j++));
                } else {
                    sb.append(sb.charAt(j++));
                    i++;
                }
            }
            end = i - 1;
            reverseString(sb, start, end);
            // Add a space after the word if it's not the last word
            if (j < n) {
                if (i < sb.length()) {
                    sb.setCharAt(i++, ' ');
                } else {
                    sb.append(' ');
                    i++;
                }
            }
        }
        if (i > 0 && sb.charAt(i - 1) == ' ')
            i--;

        return sb.substring(0, i);
    }

    private void reverseString(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    // GPT
    public String reverseWords_1(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // 1. Reverse whole string
        reverse(arr, 0, n - 1);

        int i = 0, j = 0, write = 0;

        while (i < n) {
            // skip spaces
            while (i < n && arr[i] == ' ')
                i++;
            if (i >= n)
                break;

            // write a space before next word (not for the first word)
            if (write > 0)
                arr[write++] = ' ';

            // mark word start
            j = i;
            while (j < n && arr[j] != ' ')
                j++;

            // copy the word forward
            for (int k = i; k < j; k++) {
                arr[write++] = arr[k];
            }

            // reverse this word in place
            reverse(arr, write - (j - i), write - 1);

            i = j;
        }

        return new String(arr, 0, write);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }
}
