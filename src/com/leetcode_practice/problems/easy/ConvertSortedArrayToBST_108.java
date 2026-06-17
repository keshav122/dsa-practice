/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

public class ConvertSortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(0, nums.length - 1, nums);
    }

    private TreeNode solve(int l, int r, int[] nums) {
        if (l > r)
            return null;
        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(l, mid - 1, nums);
        root.right = solve(mid + 1, r, nums);
        return root;
    }
}
