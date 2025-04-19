package com.roadmap.arrays.logic_building;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoSortedArrays {
    public int[] intersectionArray_BF(int[] nums1, int[] nums2) {
        List<Integer> unionList = new LinkedList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                unionList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[unionList.size()];
        int k = 0;
        for (int element : unionList) {
            result[k++] = element;
        }
        return result;
    }

    // BruteForce Using Set
    public int[] intersectionArray_BF1(int[] nums1, int[] nums2) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set.add(num);
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int val : set) {
            res[i] = val;
            i++;
        }
        Arrays.sort(res);
        return res;
    }

    public int[] unionArray_Optimal1(int[] nums1, int[] nums2) {
        Set<Integer> unionSet = new LinkedHashSet<>();
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                unionSet.add(nums1[i]);
                i++;
            } else {
                unionSet.add(nums2[j]);
                j++;
            }
        }

        while (i < n1) {
            unionSet.add(nums1[i]);
            i++;
        }
        while (j < n2) {
            unionSet.add(nums2[j]);
            j++;
        }

        int[] res = new int[unionSet.size()];
        int k = 0;
        for (int val : unionSet) {
            res[k++] = val;
        }
        return res;
    }

    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m) {
            // Case 1 and 2
            if (nums1[i] <= nums2[j]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                    unionList.add(nums1[i]);
                }
                i++;
            }
            // Case 3
            else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                    unionList.add(nums2[j]);
                }
                j++;
            }
        }

        // Add remaining elements of nums1, if any
        while (i < n) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                unionList.add(nums1[i]);
            }
            i++;
        }

        // Add remaining elements of nums2, if any
        while (j < m) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                unionList.add(nums2[j]);
            }
            j++;
        }

        // Convert List<Integer> to int[]
        int[] union = new int[unionList.size()];
        for (int k = 0; k < unionList.size(); k++) {
            union[k] = unionList.get(k);
        }

        return union;
    }

    public static void main(String[] args) {
        int[] nums1 = { -45, -45, 0, 0, 2 };
        int[] nums2 = { -50, -45, 0, 0, 5, 7 };
        IntersectionOfTwoSortedArrays i = new IntersectionOfTwoSortedArrays();
        int[] res = i.intersectionArray_BF(nums1, nums2);
        for (int a : res) {
            System.out.print(a + " ");
        }

    }
}
