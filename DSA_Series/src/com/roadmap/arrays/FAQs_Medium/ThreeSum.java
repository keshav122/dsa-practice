package com.roadmap.arrays.FAQs_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum_BF(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        Collections.sort(li);
                        if (!ans.contains(li)) {
                            ans.add(li);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_better(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int target = -(nums[i] + nums[j]);
                if (hashSet.contains(target)) {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(target);
                    Collections.sort(li);
                    if (!ans.contains(li)) {
                        ans.add(li);
                    }
                }
                hashSet.add(nums[j]);
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_TwoPointer(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> li = new LinkedList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    if (!ans.contains(li)) {
                        ans.add(li);
                    }
                    int t1 = nums[j];
                    int l = j + 1;
                    while (nums[l] == t1 && l < k) {
                        l++;
                        j++;
                    }

                    int t2 = nums[k];
                    int m = k - 1;
                    while (nums[m] == t2 && m > j) {
                        m--;
                        k--;
                    }
                } else if (sum > 0) {
                    int temp = nums[k];
                    int m = k - 1;
                    while (nums[m] == temp && m > j) {
                        m--;
                        k--;
                    }
                } else {
                    int temp = nums[j];
                    int l = k + 1;
                    while (nums[l] == temp && l < k) {
                        l++;
                        j++;
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum_OptimalOfficialSol(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    ans.add(li);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        return ans;
    }
}
