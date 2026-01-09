package com.leetcode_practice.problems.medium;

public class SmallestSubtreeWithAllTheDeepestNodes_865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        int leftDepth = getDepthOfSubtree(root.left);
        int rightDepth = getDepthOfSubtree(root.right);
        if (leftDepth == rightDepth) {
            return root;
        } else if (leftDepth < rightDepth) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return subtreeWithAllDeepest(root.left);
        }
    }

    private int getDepthOfSubtree(TreeNode root) {
        if (null == root)
            return 0;
        return 1 + Math.max(getDepthOfSubtree(root.left), getDepthOfSubtree(root.right));
    }

    public TreeNode subtreeWithAllDeepest_optimal(TreeNode root) {
        return subtreeWithHelper(root).node;
    }

    public Pair subtreeWithHelper(TreeNode root) {
        if (root == null)
            return new Pair(null, 0);
        Pair left = subtreeWithHelper(root.left);
        Pair right = subtreeWithHelper(root.right);
        if (left.depth == right.depth) {
            return new Pair(root, left.depth + 1);
        } else if (left.depth < right.depth) {
            return new Pair(right.node, right.depth + 1);
        } else {
            return new Pair(left.node, left.depth + 1);
        }
    }

    static class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}

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