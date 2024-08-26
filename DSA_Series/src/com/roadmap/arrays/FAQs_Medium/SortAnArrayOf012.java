package com.roadmap.arrays.FAQs_Medium;

public class SortAnArrayOf012 {
    public void sortZeroOneTwo(int[] nums) {
        int zeroCount = 0, oneCount = 0, n = nums.length;
        for (int num : nums) {
            if (num == 0)
                zeroCount++;
            else if (num == 1)
                oneCount++;
        }

        int i = 0;
        while (i < zeroCount) {
            nums[i] = 0;
            i++;
        }
        while (i < zeroCount + oneCount) {
            nums[i] = 1;
            i++;
        }
        while (i < n) {
            nums[i] = 2;
            i++;
        }
    }

    public void sortZeroOneTwoBCNF(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[mid] = temp;
                nums[low] = 0;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[mid] = temp;
                nums[high] = 2;
                high--;
            }
        }

    }
}
