package com.roadmap.binary_trees.FAQs;

import java.util.*;

public class BoundaryTraversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (!isLeaf(root))
            ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> ans) {
        TreeNode currNode = node.left;
        while (currNode != null) {
            if (!isLeaf(currNode))
                ans.add(currNode.data);
            if (currNode.left != null)
                currNode = currNode.left;
            else
                currNode = currNode.right;
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> ans) {
        TreeNode currNode = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (currNode != null) {
            if (!isLeaf(currNode))
                temp.add(currNode.data);
            if (currNode.right != null)
                currNode = currNode.right;
            else
                currNode = currNode.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    private void addLeaves(TreeNode node, List<Integer> ans) {
        if (isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        if (node.left != null)
            addLeaves(node.left, ans);
        if (node.right != null)
            addLeaves(node.right, ans);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        return (node.left == null && node.right == null);
    }
}
