package com.dsa_series.roadmap.binary_search_trees.FAQs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BSTIteratorBF {
    private List<Integer> values;
    int index;

    public BSTIteratorBF(TreeNode root) {
        values = new ArrayList<>();
        inorder(root);
        index = -1;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        values.add(root.data);
        inorder(root.right);
    }

    public boolean hasNext() {
        return (1 + index) < values.size();
    }

    public int next() {
        return values.get(++index);
    }
}

public class BSTIterator {
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAllValues(root);
    }

    private void pushAllValues(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode top = st.pop();
        pushAllValues(top.right);
        return top.data;
    }
}
