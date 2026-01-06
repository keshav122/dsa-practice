package com.leetcode_practice.problems.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumLevelSumOfABinaryTree_1161 {
    public int maxLevelSum_BF(TreeNode root) {
        int[] sum = new int[10000];
        Arrays.fill(sum, 0);
        int[] highestUpdated = new int[1];
        highestUpdated[0] = 1;
        updateSum(sum, root, 1, highestUpdated);
        int maxVal = Integer.MIN_VALUE;
        int maxLevel = 1;
        for (int i = 1; i <= highestUpdated[0]; i++) {
            if (sum[i] > maxVal) {
                maxVal = sum[i];
                maxLevel = i;
            }
        }
        return maxLevel;
    }

    private void updateSum(int[] sum, TreeNode root, int level, int[] highestUpdated) {
        if (root == null)
            return;
        sum[level] += root.val;
        highestUpdated[0] = Math.max(highestUpdated[0], level);
        updateSum(sum, root.left, level + 1, highestUpdated);
        updateSum(sum, root.right, level + 1, highestUpdated);
    }

    public int maxLevelSum(TreeNode root) {
        if (null == root)
            return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 1;
        int maxSum = root.val;
        int maxLevel = 1;
        while (!q.isEmpty()) {
            int sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}
