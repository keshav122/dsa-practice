package com.dsa_series.roadmap.arrays.contest;

public class NumberOfJumps {
    public int numberOfJumps(int[] nums, int k) {
        int n = nums.length;
        return mergeSort(nums, k, 0, n - 1);
    }

    private int mergeSort(int[] nums, int k, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;
        int mid = (low + high) / 2;
        // Adding count from the left subarray
        count += mergeSort(nums, k, low, mid);
        // Adding count from the right subarray
        count += mergeSort(nums, k, mid + 1, high);
        // counting jumps from each subarray
        count += countJumps(nums, k, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    private int countJumps(int[] nums, int k, int low, int mid, int high) {
        int count = 0, left = low, right = mid + 1;
        while (left <= mid) {
            while (right <= high && nums[left] + k >= nums[right])
                right++;
            count += high - right + 1;
            left++;
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int index = 0, left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}
