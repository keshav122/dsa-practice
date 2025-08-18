package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST_530 {
    public int getMinimumDifference_BF(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getAllNodes(root, nodes);
        Collections.sort(nodes);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nodes.size(); i++) {
            minDiff = Math.min(nodes.get(i) - nodes.get(i - 1), minDiff);
        }
        return minDiff;
    }

    private void getAllNodes(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;
        if (root != null) {
            nodes.add(root.val);
        }
        getAllNodes(root.left, nodes);
        getAllNodes(root.right, nodes);
    }

    // This solution doesnt work because it fails for a case where there are
    // only left values
    /*
     * 4
     * /
     * 2
     * /
     * 1
     * The answer does not involves the root node
     */

    public int getMinimumDifference(TreeNode root) {
        int leftDiff = Math.abs(root.val - getMaxLeftSubtree(root.left));
        int rightDiff = Math.abs(root.val - getMinimumRightSubtree(root.right));
        return Math.min(leftDiff, rightDiff);
    }

    private int getMinimumRightSubtree(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        return Math.max(root.val, getMinimumRightSubtree(root.left));
    }

    private int getMaxLeftSubtree(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.val, getMaxLeftSubtree(root.right));

    }

    // TODO The optimal solution involves calculating the minDiff while
    // calculating the inorder
    public int getMinimumDifference_Optimal(TreeNode root) {
        return 0;
    }
}
