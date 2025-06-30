package com.dsa_series.roadmap.binary_trees.theory_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> preorder_Iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            res.add(top.data);
            if (top.right != null) {
                st.add(top.right);
            }
            if (top.left != null) {
                st.add(top.left);
            }
        }
        return res;
    }
}
