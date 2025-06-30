package com.dsa_series.roadmap.beginnerproblems.basic_arrays;

public class IsArraySorted {
    boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}
