package com.dsa_series.roadmap.heaps.theory_and_implementation;

public class CheckIfArrayRepresentsMinHeap {
    public boolean isHeap(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int lChild = 2 * i + 1;
            int rChild = 2 * i + 2;
            if (lChild < n && nums[lChild] < nums[i]) {
                return false;
            }
            if (rChild < n && nums[rChild] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isHeap_Official(int[] nums) {
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            int lChild = 2 * i + 1;
            int rChild = 2 * i + 2;
            if (lChild < n && nums[lChild] < nums[i]) {
                return false;
            }
            if (rChild < n && nums[rChild] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
