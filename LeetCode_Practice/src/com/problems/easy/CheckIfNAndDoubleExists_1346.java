package com.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckIfNAndDoubleExists_1346 {

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> valueIndiceMap = new HashMap<>();
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            } else {
                valueIndiceMap.put(arr[i], i);
                boolean isHalfPresent = arr[i] % 2 == 0 && valueIndiceMap.containsKey(arr[i] / 2);
                boolean isTwicePresent = valueIndiceMap.containsKey(2 * arr[i]);
                if (isHalfPresent || isTwicePresent || zeroCount > 1)
                    return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0 };
        CheckIfNAndDoubleExists_1346 check = new CheckIfNAndDoubleExists_1346();
        System.out.println(check.checkIfExist(arr));
    }
}
