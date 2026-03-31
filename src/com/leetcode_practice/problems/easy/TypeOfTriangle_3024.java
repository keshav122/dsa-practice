package com.leetcode_practice.problems.easy;

public class TypeOfTriangle_3024 {
    public String triangleType(int[] nums) {
        boolean isNotTriangle = (nums[0] + nums[1] <= nums[2]) || (nums[1] + nums[2] <= nums[0])
                || (nums[0] + nums[2] <= nums[1]);
        if (isNotTriangle)
            return "none";
        if (nums[1] == nums[2] && nums[2] == nums[0]) {
            return "equilateral";
        } else if (nums[1] == nums[2] || nums[2] == nums[0] || nums[0] == nums[1]) {
            return "isosceles";
        }
        return "scalene";
    }
}
