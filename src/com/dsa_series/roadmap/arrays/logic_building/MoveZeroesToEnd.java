package com.dsa_series.roadmap.arrays.logic_building;

public class MoveZeroesToEnd {
    public void moveZeroesBF(int[] nums) {
        int currPointer = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[currPointer] = nums[i];
                currPointer++;
            }
            i++;
        }
        while (currPointer < nums.length) {
            nums[currPointer] = 0;
            currPointer++;
        }
    }

    public void moveZeroesOptimal(int[] nums) {
        int n = nums.length;
        // First find the first place at which 0 occurs
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        // If there are no zeroes nothing required
        if (j == -1)
            return;

        // j will only move 1 place after swapping as
        // if there are non-zero numbers we are constantly swapping the zeroes
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

}
