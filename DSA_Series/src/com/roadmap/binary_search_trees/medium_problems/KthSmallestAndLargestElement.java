package com.roadmap.binary_search_trees.medium_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestAndLargestElement {
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();
        inorder(root, li);
        List<Integer> ans = new ArrayList<>();
        ans.add(li.get(k - 1));
        ans.add(li.get(li.size() - k));
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> li) {
        if (root == null) {
            return;
        }
        inorder(root.left, li);
        li.add(root.data);
        inorder(root.right, li);
    }

    public List<Integer> kLargesSmall_better(TreeNode root, int k) {
        int totalNodes = getNodesCount(root);
        List<Integer> ans = new ArrayList<>();
        inorder_iterative(root, ans, k, totalNodes);
        return ans;
    }

    private void inorder_iterative(TreeNode root, List<Integer> ans, int k, int totalNodes) {
        int count = 0;
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
                count++;
                if (count == k || count == totalNodes - k) {
                    ans.add(node.data);
                }
                node = node.right;
            }
        }
    }

    private int getNodesCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNodesCount(root.left) + getNodesCount(root.right);

    }

}
