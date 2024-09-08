package com.roadmap.arrays.logic_building;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UnionOfTwoSortedArrays {

    public int[] unionArray_BF(int[] nums1, int[] nums2) {
        List<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (!unionList.contains(nums1[i])) {
                    unionList.add(nums1[i]);
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (!unionList.contains(nums2[j])) {
                    unionList.add(nums2[j]);
                }
                j++;
            } else {
                if (!unionList.contains(nums1[i])) {
                    unionList.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            if (!unionList.contains(nums1[i])) {
                unionList.add(nums1[i]);
            }
            i++;
        }
        while (j < nums2.length) {
            if (!unionList.contains(nums2[j])) {
                unionList.add(nums2[j]);
            }
            j++;
        }

        Collections.sort(unionList);
        int[] result = new int[unionList.size()];
        int k = 0;
        for (int element : unionList) {
            result[k++] = element;
        }
        return result;

    }

    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> unionSet = new LinkedHashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                unionSet.add(nums1[i]);
                if (nums1[i] == nums2[j]) {
                    j++;
                }
                i++;
            } else {
                unionSet.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length) {
            unionSet.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            unionSet.add(nums2[j]);
            j++;
        }

        int[] result = new int[unionSet.size()];
        int k = 0;
        for (int element : unionSet) {
            result[k++] = element;
        }
        return result;
    }
}
