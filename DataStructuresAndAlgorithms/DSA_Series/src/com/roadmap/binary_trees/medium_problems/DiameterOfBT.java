package com.roadmap.binary_trees.medium_problems;

public class DiameterOfBT {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxheight = height(root.left) + height(root.right);
        int lh = diameterOfBinaryTree(root.left);
        int rh = diameterOfBinaryTree(root.right);
        return Math.max(maxheight, Math.max(lh, rh));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int diameterOfBinaryTree_better(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] = 0;
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

}
