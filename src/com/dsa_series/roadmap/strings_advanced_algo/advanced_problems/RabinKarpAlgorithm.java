package com.dsa_series.roadmap.strings_advanced_algo.advanced_problems;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
    public List<Integer> search(String pat, String txt) {
        List<Integer> li = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        for (int i = 0; i <= n - m; i++) {
            if (txt.charAt(i) == pat.charAt(0) && txt.substring(i, i + m).contentEquals(pat)) {
                li.add(i);
            }
        }
        return li;
    }

    public List<Integer> searchRKAlgo(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        int p = 7, MOD = 101, pRight = 1, hashPat = 0, hashTxt = 0;
        for (int i = 0; i < m; i++) {
            hashPat = (hashPat + ((pat.charAt(i) - 'a' + 1) * pRight) % MOD) % MOD;
            hashTxt = (hashTxt + ((txt.charAt(i) - 'a' + 1) * pRight) % MOD) % MOD;
            pRight = (pRight * p) % MOD;
        }
        List<Integer> ans = new ArrayList<>();
        int pLeft = 1;
        for (int i = 0; i <= n - m; i++) {
            if (hashPat == hashTxt) {
                if (txt.substring(i, i + m).contentEquals(pat)) {
                    ans.add(i);
                }
            }
            if (i < n - m) {
                hashTxt = (hashTxt - ((txt.charAt(i) - 'a' + 1) * pLeft) % MOD + MOD) % MOD;
                hashTxt = (hashTxt + ((txt.charAt(i + m) - 'a' + 1) * pRight) % MOD) % MOD;

                hashPat = (hashPat * p) % MOD;
                pLeft = (pLeft * p) % MOD;
                pRight = (pRight * p) % MOD;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String pattern = "ll";
        String text = "hello";
        RabinKarpAlgorithm obj = new RabinKarpAlgorithm();
        List<Integer> ans = obj.search(pattern, text);
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }

}
