package com.roadmap.binary_search_trees.medium_problems;

public class LCAInBST {
    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.data == p || root.data == q)
            return root;
        int r = root.data;
        if ((p < r && q > r) || (p > r && q < r))
            return root;
        if (p < r && q < r) {
            return lca(root.left, p, q);
        } else {
            return lca(root.right, p, q);
        }
    }

    public TreeNode lca_1(TreeNode root, int p, int q) {
        if (root == null)
            return null;
        int r = root.data;
        if (p < r && q < r) {
            return lca(root.left, p, q);
        }
        if (p > r && q > r) {
            return lca(root.right, p, q);
        }
        return root;
    }

    public TreeNode lcaIterative(TreeNode root, int p, int q) {
        if (root == null || root.data == p || root.data == q)
            return root;
        while (root != null) {
            int r = root.data;
            if (p < r && q < r) {
                root = root.left;
            } else if (p > r && q > r) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

}
