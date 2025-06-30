package com.dsa_series.roadmap.binary_search_trees.medium_problems;

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            new TreeNode(val);
        TreeNode curr = root, prev = root;
        TreeNode node = new TreeNode(val);
        while (curr != null) {
            prev = curr;
            if (curr.data < val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }

        }
        if (prev.data > val) {
            prev.left = node;
        } else {
            prev.right = node;
        }
        return root;
    }

    public TreeNode insertIntoBSTEditorial(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode curr = root;
        while (true) {
            if (curr.data < val) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }

            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
