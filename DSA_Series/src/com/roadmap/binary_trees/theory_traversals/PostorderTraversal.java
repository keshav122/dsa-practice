package com.roadmap.binary_trees.theory_traversals;

import java.util.ArrayList;
import java.util.List;

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
}
