package com.dsa_series.roadmap.beginnerproblems.basic_maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisorsOfNumber {

    public int[] divisors_Optimal(int n) {
        List<Integer> smallDivisors = new ArrayList<>();
        List<Integer> largeDivisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                smallDivisors.add(i);
                if (i != (n / i)) {
                    largeDivisors.add(n / i);
                }

            }
        }
        int len = smallDivisors.size() + largeDivisors.size();
        int[] ans = new int[len];
        int i = 0;
        for (int num : smallDivisors) {
            ans[i++] = num;
        }
        for (int j = largeDivisors.size() - 1; j >= 0; j--) {
            ans[i++] = largeDivisors.get(j);
        }

        return ans;
    }

    public int[] divisors(int n) {
        List<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisorList.add(i);
                if (i != (n / i)) {
                    divisorList.add(n / i);
                }

            }
        }
        int[] divisorsArr = new int[divisorList.size()];
        for (int i = 0; i < divisorsArr.length; i++) {
            divisorsArr[i] = divisorList.get(i);
        }
        Arrays.sort(divisorsArr);
        return divisorsArr;
    }
}
