package com.roadmap.binary_search_trees.FAQs;

public class CorrectBSTWithNodesSwapped {
    void recoverTree(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null && root.left.data > root.data) {
            swapValues(root, root.left);
        }
        if (root.right != null && root.right.data < root.data) {
            swapValues(root, root.right);
        }
        recoverTree(root.left);
        recoverTree(root.right);
    }

    private void swapValues(TreeNode a, TreeNode b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}
