package com.dsa_series.roadmap.binary_search_trees.medium_problems;

public class CheckIfATreeIsBSTOrNot {

    public boolean isBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (root.data <= minValue || root.data >= maxValue)
            return false;
        return isValidBST(root.left, minValue, root.data) && isValidBST(root.right, root.data, maxValue);
    }
}
