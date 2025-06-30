package com.dsa_series.roadmap.binary_trees.medium_problems;

import java.util.ArrayList;
import java.util.List;

public class CheckForSymmetricalBTs {
    public boolean isSymmetric_BF(TreeNode root) {
        if (root == null)
            return true;
        List<Integer> res = inorder(root);
        int i = 0, j = res.size() - 1;
        while (i <= j) {
            if (res.get(i) != res.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        inorder(root, li);
        return li;
    }

    private void inorder(TreeNode root, List<Integer> li) {
        if (root == null)
            return;
        inorder(root.left, li);
        li.add(root.data);
        inorder(root.right, li);
    }

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return (left == right);
        }
        if (left.data != right.data)
            return false;

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
