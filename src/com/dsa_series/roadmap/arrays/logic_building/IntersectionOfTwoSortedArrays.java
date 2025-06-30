package com.dsa_series.roadmap.arrays.logic_building;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoSortedArrays {
    public int[] intersectionArray_BF1(int[] nums1, int[] nums2) {
        List<Integer> ansList = new ArrayList<>();
        int[] visited = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && visited[j] == 0) {
                    ansList.add(nums2[j]);
                    visited[j] = 1;
                    break;
                } else if (nums2[j] > nums1[i])
                    break;
            }
        }
        int[] ans = new int[ansList.size()];
        for (int k = 0; k < ansList.size(); k++) {
            ans[k] = ansList.get(k);
        }
        return ans;
    }

    public int[] intersectionArray_BF2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap1 = new HashMap<>();
        Map<Integer, Integer> freqMap2 = new HashMap<>();

        for (int num : nums1) {
            freqMap1.merge(num, 1, Integer::sum);
        }

        for (int num : nums2) {
            freqMap2.merge(num, 1, Integer::sum);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap1.entrySet()) {
            int key = entry.getKey();
            if (freqMap2.containsKey(key)) {
                int count = Math.min(entry.getValue(), freqMap2.get(key));
                for (int i = 1; i <= count; i++) {
                    list.add(key);
                }
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int val : list) {
            res[i++] = val;
        }
        Arrays.sort(res);
        return res;
    }

    public int[] intersectionArray_BF3(int[] nums1, int[] nums2) {
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

    public int[] intersectionArrayOptimal(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        List<Integer> intersectionList = new LinkedList<>();
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                intersectionList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return listToArr(intersectionList);
    }

    private int[] listToArr(List<Integer> li) {
        int[] ans = new int[li.size()];
        for (int k = 0; k < li.size(); k++) {
            ans[k] = li.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { -45, -45, 0, 0, 2 };
        int[] nums2 = { -50, -45, 0, 0, 5, 7 };
        IntersectionOfTwoSortedArrays i = new IntersectionOfTwoSortedArrays();
        int[] res = i.intersectionArray_BF1(nums1, nums2);
        for (int a : res) {
            System.out.print(a + " ");
        }

    }
}
