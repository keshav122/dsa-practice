package com.roadmap.binary_trees.constant_space_traversals;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}
