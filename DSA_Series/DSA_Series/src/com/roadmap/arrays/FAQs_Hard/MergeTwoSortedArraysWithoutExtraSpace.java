package com.roadmap.arrays.FAQs_Hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public void merge_Optimal1(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        // The to index is exclusive range
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    // Using the gap method - This concept is taken from shell sorting
    public void merge_Optimal2(int[] nums1, int m, int[] nums2, int n) {
        // Rather than using if-else condition if add modulus by 2 because
        // we want to get the ceil of (m+n)/2 as the initial gap value
        int len = m + n;
        int gap = (len) / 2 + (len) % 2;
        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < len) {
                // left is in nums1 and right is in nums2
                if (left < m && right >= m) {
                    if (nums1[left] >= nums2[right - m]) {
                        swap(nums1, left, nums2, right - m);
                    }
                }
                // both are in second array
                else if (left >= m) {
                    if (nums2[left - m] >= nums2[right - m]) {
                        swap(nums2, left - m, nums2, right - m);
                    }
                } else {
                    if (nums1[left] >= nums1[right]) {
                        swap(nums1, left, nums1, right);
                    }
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            else
                gap = (gap / 2) + (gap % 2);
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    private void swap(int[] nums1, int left, int[] nums2, int right) {
        int temp = nums1[left];
        nums1[left] = nums2[right];
        nums2[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = { -5, -2, 4, 5, 0, 0, 0 };
        int[] arr2 = { -3, 1, 8 };
        int n = arr2.length;
        MergeTwoSortedArraysWithoutExtraSpace obj = new MergeTwoSortedArraysWithoutExtraSpace();
        obj.merge_Optimal1(arr1, 4, arr2, n);
        for (int num : arr1) {
            System.out.println(num);
        }
    }
}
