package com.dsa_series.roadmap.arrays.FAQs_Medium;

/*Author: keshav122 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public List<List<Integer>> fourSum_BF(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> li = new ArrayList<>();
                            li.add(nums[i]);
                            li.add(nums[j]);
                            li.add(nums[k]);
                            li.add(nums[l]);
                            Collections.sort(li);
                            if (!ans.contains(li)) {
                                ans.add(li);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> fourSum_better(int[] nums, int target) {
        Set<List<Integer>> quadruples = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (nums[i] + nums[j] + nums[k]);
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(quadruplet);
                        quadruples.add(quadruplet);
                    }
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(quadruples);
        return ans;
    }

    // Although it is almost optimal , because of the while loop difference in this
    // and the
    // below implementation and this is not getting accepted.
    public List<List<Integer>> fourSum_MinorlyLessOptimal(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> li = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(li);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (l > k && nums[l] == nums[l - 1])
                            l--;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(nums[l]);
                        ans.add(li);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (l > k && nums[l] == nums[l - 1])
                            l--;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}
