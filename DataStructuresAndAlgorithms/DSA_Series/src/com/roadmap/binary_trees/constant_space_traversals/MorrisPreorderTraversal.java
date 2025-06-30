package com.roadmap.binary_trees.constant_space_traversals;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                preorder.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    preorder.add(curr.data);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}
