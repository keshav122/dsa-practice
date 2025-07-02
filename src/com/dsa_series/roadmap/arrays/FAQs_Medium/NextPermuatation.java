package com.dsa_series.roadmap.arrays.FAQs_Medium;

public class NextPermuatation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        // Find the breakpoint - longest matching prefix
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= nums[index]) {
                // swap the numbers
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index + 1, n - 1);
    }

    private void reverse(int[] arr, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
