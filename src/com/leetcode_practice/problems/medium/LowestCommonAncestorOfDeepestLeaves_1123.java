package com.leetcode_practice.problems.medium;

public class LowestCommonAncestorOfDeepestLeaves_1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
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
