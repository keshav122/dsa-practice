/*Author: keshav122 */
package com.dsa_series.roadmap.arrays.FAQs_Hard;

public class CountInversions {
    public long numberOfInversions_BF(int[] nums) {
        long inversionCount = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

    // The idea or approach is that we are given two separate sorted arrays
    // we can calculate the number of pairs in which the element in the first array
    // is greater than the
    // element in the second array.
    // For eg {3, 8 , 16,27} and {1, 2, 4, 5}
    // Now if 3 is greater than 1 and all the other numbers in the first array will
    // be
    // greater than 1 because the array is sorted.
    // So we could use a merge sort approach and during the sorting we can calculate
    // the number of pairs
    public long numberOfInversions(int[] nums) {
        int n = nums.length;
        return mergeSortCount(nums, 0, n - 1);
    }

    private long mergeSortCount(int[] nums, int startIndex, int endIndex) {
        long count = 0;
        if (startIndex >= endIndex) {
            return count;
        }
        int midIndex = (startIndex + endIndex) / 2;
        count += mergeSortCount(nums, startIndex, midIndex);
        count += mergeSortCount(nums, midIndex + 1, endIndex);
        count += mergeArrays(nums, startIndex, midIndex, endIndex);
        return count;
    }

    private long mergeArrays(int[] nums, int startIndex, int midIndex, int endIndex) {
        long count = 0;
        int left = startIndex;
        int right = midIndex + 1;
        int[] temp = new int[endIndex - startIndex + 1];
        int k = 0;
        while (left <= midIndex && right <= endIndex) {
            if (nums[left] > nums[right]) {
                count += midIndex - left + 1;
                temp[k] = nums[right];
                right++;
            } else {
                temp[k] = nums[left];
                left++;
            }
            k++;
        }

        while (left <= midIndex) {
            temp[k] = nums[left];
            left++;
            k++;
        }

        while (right <= endIndex) {
            temp[k] = nums[right];
            right++;
            k++;
        }
        // System.arraycopy(temp, 0, nums, low, high - low + 1);
        for (left = startIndex; left <= endIndex; left++) {
            nums[left] = temp[left - startIndex];
        }
        return count;
    }
}
