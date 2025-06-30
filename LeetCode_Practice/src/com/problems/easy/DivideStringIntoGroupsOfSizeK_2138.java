package com.problems.easy;

public class DivideStringIntoGroupsOfSizeK_2138 {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int len = (n % k == 0) ? n / k : (n / k) + 1;
        String[] ans = new String[len];
        int fillCharReq = (n % k == 0) ? 0 : k - (n % k);
        String append = "";
        for (int i = 0; i < fillCharReq; i++) {
            append += fill;
        }

        int i = 0;
        int j = 0;
        while (j < len - 1) {
            ans[j] = s.substring(i, i + k);
            i += k;
            j++;
        }
        ans[len - 1] = (fillCharReq == 0) ? s.substring(i, n) : s.substring(i, n) + append;
        return ans;
    }

    public String[] divideString_better(String s, int k, char fill) {
        int n = s.length();
        int groups = (n % k == 0) ? n / k : (n / k) + 1;
        int fillCharReq = (n % k == 0) ? 0 : k - (n % k);
        String append = String.valueOf(fill).repeat(fillCharReq);
        String[] ans = new String[groups];
        int i = 0;
        int j = 0;
        while (j < groups - 1) {
            ans[j] = s.substring(i, i + k);
            i += k;
            j++;
        }
        ans[groups - 1] = (fillCharReq == 0) ? s.substring(i, n) : s.substring(i, n) + append;
        return ans;
    }

    public String[] divideString_best(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] ans = new String[groups];
        StringBuilder sb = new StringBuilder(s);
        int remainder = n % k;
        if (remainder != 0) {
            sb.append(String.valueOf(fill).repeat(k - remainder));
        }
        for (int i = 0; i < groups; i++) {
            ans[i] = sb.substring(i * k, (i + 1) * k);
        }
        return ans;
    }
}
