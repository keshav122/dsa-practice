package com.roadmap.binary_search_trees.FAQs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CorrectBSTWithNodesSwapped {
    void recoverTree_BF(TreeNode root) {
        List<Integer> allNodes = new ArrayList<>();
        postOrder(root, allNodes);
        Collections.sort(allNodes);
        inorder(root, allNodes, new int[] { 0 });

    }

    private void inorder(TreeNode root, List<Integer> allNodes, int[] counter) {
        if (root == null)
            return;
        inorder(root.left, allNodes, counter);
        root.data = allNodes.get(counter[0]);
        counter[0]++;
        inorder(root.right, allNodes, counter);

    }

    private void postOrder(TreeNode root, List<Integer> allNodes) {
        if (root == null) {
            return;
        }
        postOrder(root.left, allNodes);
        postOrder(root.right, allNodes);
        allNodes.add(root.data);
    }

    // Optimal solution
    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE), last = null;

    void recoverTree(TreeNode root) {
        inorder(root);
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
