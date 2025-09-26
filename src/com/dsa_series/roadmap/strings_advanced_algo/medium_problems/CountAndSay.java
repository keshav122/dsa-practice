
package com.dsa_series.roadmap.strings_advanced_algo.medium_problems;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String prev = countAndSay(n - 1);
        int count = 1;
        String res = "";
        int i = 1;
        for (; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {

                res += (char) ('0' + count); // Add frequency
                res += prev.charAt(i - 1); // Add the digit
                count = 1;
            }
        }
        res += (char) ('0' + count);
        res += prev.charAt(i - 1);
        return res;
    }
}
