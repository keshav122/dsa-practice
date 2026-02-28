package com.leetcode_practice.contest.biweekly.count_177;

public class MergeCloseCharacters {
    public static String mergeCharacters(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < n - 1) {
            int dist = 0;
            char ch = arr[i];
            boolean flag = false;
            for (int j = i + 1; dist < k && j < n; j++) {
                if (ch != '0' && arr[j] == ch) {
                    arr[j] = '0';
                    dist++;
                    flag = true;
                    break;
                } else if (arr[j] != '0') {
                    dist++;
                }
            }
            if (flag)
                i = 0;
            else
                i++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch != '0') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "yybyzybz";
        System.out.println(mergeCharacters(s, 2));

    }
}
