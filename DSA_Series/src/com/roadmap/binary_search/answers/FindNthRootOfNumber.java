package com.roadmap.binary_search.answers;

public class FindNthRootOfNumber {

    public int NthRoot(int N, int M) {
        int low = 0;
        int high = M;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (Math.pow(mid, N) == M) {
                return mid;
            } else if (Math.pow(mid, N) > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private long pow(int n, int mid) {
        int product = n;
        for (int i = 1; i < mid; i++) {
            product *= n;
        }
        return product;
    }
}
