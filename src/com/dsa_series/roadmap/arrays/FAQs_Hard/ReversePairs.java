package com.dsa_series.roadmap.arrays.FAQs_Hard;

public class ReversePairs {
    public int reversePairs_BF(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int reversePairs_Optimal(int[] nums) {
        int n = nums.length;
        return mergeSortReversePairs(nums, 0, n - 1);
    }

    private int mergeSortReversePairs(int[] nums, int sI, int eI) {
        int count = 0;
        if (sI >= eI) {
            return count;
        }
        int mid = (sI + eI) / 2;
        count += mergeSortReversePairs(nums, sI, mid);
        count += mergeSortReversePairs(nums, mid + 1, eI);
        count += countPairs(nums, sI, mid, eI);
        merge(nums, sI, mid, eI);
        return count;
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int left = low; left <= mid; left++) {
            while (right <= high) {
                if (nums[left] > 2 * nums[right]) {
                    right++;
                } else {
                    break;
                }
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    private int merge(int[] nums, int sI, int mid, int eI) {
        int count = 0;
        int i = sI;
        int j = mid + 1;
        int[] temp = new int[eI - sI + 1];
        int k = 0;
        while (i <= mid && j <= eI) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= eI) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        for (i = sI; i <= eI; i++) {
            nums[i] = temp[i - sI];
        }
        return count;
    }
}
