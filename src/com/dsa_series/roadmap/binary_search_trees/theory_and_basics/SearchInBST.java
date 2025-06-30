package com.dsa_series.roadmap.binary_search_trees.theory_and_basics;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.data == val)
            return root;
        if (root.data > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null && root.data != val) {
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }
}
