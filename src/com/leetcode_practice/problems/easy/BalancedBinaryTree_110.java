/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

public class BalancedBinaryTree_110 {
    public boolean isBalanced_BF(TreeNode root) {
        if (root == null)
            return true;
        int lH = height(root.left);
        int rH = height(root.right);
        if (Math.abs(lH - rH) > 1)
            return false;
        return isBalanced_BF(root.left) && isBalanced_BF(root.right);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced_better(TreeNode root) {
        if (root == null)
            return true;
        return bal(root).isBal;
    }

    private Pair bal(TreeNode root) {
        if (root == null)
            return new Pair(true, 0);
        Pair left = bal(root.left);
        Pair right = bal(root.right);

        if (!left.isBal || !right.isBal || Math.abs(left.height - right.height) > 1) {
            return new Pair(false, 0);
        }
        return new Pair(true, 1 + Math.max(left.height, right.height));

    }

    public boolean isBalanced_Optimal(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        if (left == -1)
            return -1;

        int right = dfs(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);
    }
}

class Pair {
    boolean isBal;
    int height;

    public Pair(boolean isBal, int height) {
        this.isBal = isBal;
        this.height = height;
    }
}
