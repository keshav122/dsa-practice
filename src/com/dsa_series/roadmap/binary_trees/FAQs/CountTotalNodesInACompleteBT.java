package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.LinkedList;
import java.util.Queue;

public class CountTotalNodesInACompleteBT {

    public int countNodes_BF(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes_BF(root.left) + countNodes_BF(root.right);
    }

    public int countNodes_1(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode node = q.poll();
            count++;
            for (int i = 0; i < size; i++) {
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int getRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
