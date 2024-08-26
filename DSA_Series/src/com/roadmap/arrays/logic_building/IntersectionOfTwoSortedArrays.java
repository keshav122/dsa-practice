package com.roadmap.arrays.logic_building;

import java.util.LinkedList;
import java.util.List;

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
