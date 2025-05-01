package com.roadmap.binary_trees.medium_problems;

public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSumAtNode(root, maxSum);
        return maxSum[0];
    }

    public int maxSumAtNode(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, maxSumAtNode(root.left, maxSum));
        int rightSum = Math.max(0, maxSumAtNode(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], root.data + leftSum + rightSum);
        return root.data + Math.max(leftSum, rightSum);
    }

}
