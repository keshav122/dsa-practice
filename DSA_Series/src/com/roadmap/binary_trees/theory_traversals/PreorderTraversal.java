package com.roadmap.binary_trees.theory_traversals;

import java.util.ArrayList;
import java.util.List;

//Root-> Left-> Right
public class PreorderTraversal {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        preorder(root, li);
        return li;
    }

    public void preorder(TreeNode root, List<Integer> li) {
        if (root == null) {
            return;
        }
        li.add(root.data);
        preorder(root.left, li);
        preorder(root.right, li);
    }
}
