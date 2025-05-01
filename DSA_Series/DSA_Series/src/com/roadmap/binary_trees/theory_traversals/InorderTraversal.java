package com.roadmap.binary_trees.theory_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Left->Root->Right
public class InorderTraversal {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.data);
        inorder(root.right, res);
    }

    public List<Integer> inorder_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty())
                    break;
                node = st.pop();
                res.add(node.data);
                node = node.right;
            }
        }
        return res;
    }
}
