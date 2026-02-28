package com.leetcode_practice.problems.easy;

public class SumOfRootToLeafBinaryNumbers_1022 {
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }
        int newVal = (value << 1) | (root.val);
        if (root.left == null && root.right == null) {
            return newVal;
        }
        return sum(root.left, newVal) + sum(root.right, newVal);
    }
}
