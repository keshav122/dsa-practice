package com.roadmap.basic_maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisorsOfNumber {
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
