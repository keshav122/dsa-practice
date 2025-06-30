package com.dsa_series.roadmap.binary_trees.theory_traversals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (null == root)
            return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.data);
    }

    public List<Integer> postorder_Iterative(TreeNode root) {
        // We will have the root -> right-> left and then reverse the result
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.data);
            if (node.left != null)
                st.push(node.left);
            if (node.right != null)
                st.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }
}
