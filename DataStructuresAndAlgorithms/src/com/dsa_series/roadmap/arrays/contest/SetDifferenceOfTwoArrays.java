package com.roadmap.arrays.contest;

public class SetDifferenceOfTwoArrays {

    public int[] setDifference(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Set<Integer> uniqueNumbers = new HashSet<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                uniqueNumbers.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                uniqueNumbers.add(nums2[j]);
                j++;
            } else {
                int val = nums1[i];
                while (i < n && nums1[i] == val)
                    i++;
                while (j < m && nums2[j] == val)
                    j++;
            }
        }
        while (i < n) {
            uniqueNumbers.add(nums1[i]);
            i++;
        }
        while (j < m) {
            uniqueNumbers.add(nums2[j]);
            j++;
        }
        int[] ans = new int[uniqueNumbers.size()];
        int k = 0;
        for (int num : uniqueNumbers) {
            ans[k++] = num;
        }
        Arrays.sort(ans);
        return ans;
    }
}
