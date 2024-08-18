package com.roadmap.basic_recursion;

public class SumOfFirstNNumbers {
    public int NnumbersSum(int N) {
        if (N == 1)
            return 1;
        return N + NnumbersSum(N - 1);
    }
}
