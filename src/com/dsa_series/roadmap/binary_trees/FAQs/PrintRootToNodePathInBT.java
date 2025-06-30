package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToNodePathInBT {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        allRootToLeaf(root, res, li);
        return res;
    }

    public void allRootToLeaf(TreeNode root, List<List<Integer>> res, List<Integer> li) {
        if (root == null)
            return;
        li.add(root.data);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(li));
        } else {
            allRootToLeaf(root.left, res, li);
            allRootToLeaf(root.right, res, li);
        }
        li.remove(li.size() - 1);
    }
}
