package com.roadmap.binary_trees.medium_problems;

public class CheckForBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced_better(TreeNode root) {
        return (dfsHeight(root) != -1);

    }

    // Changing the height method to include for checking whether the BT is balanced
    // or not
    private int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = dfsHeight(root.left);
        if (lh == -1)
            return -1;
        int rh = dfsHeight(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
}
