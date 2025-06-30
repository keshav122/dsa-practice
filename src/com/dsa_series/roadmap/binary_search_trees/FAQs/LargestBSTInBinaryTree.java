package com.dsa_series.roadmap.binary_search_trees.FAQs;

public class LargestBSTInBinaryTree {
    public int largestBST_BF(TreeNode root) {
        return isBSTAndSize(root, Integer.MIN_VALUE, Integer.MAX_VALUE).size;
    }

    private BSTInfo isBSTAndSize(TreeNode node, int minValue, int maxValue) {
        if (node == null) {
            return new BSTInfo(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        BSTInfo left = isBSTAndSize(node.left, minValue, node.data);
        BSTInfo right = isBSTAndSize(node.right, node.data, maxValue);

        if (left.isBST && right.isBST && left.max < node.data && node.data < right.min) {
            int size = left.size + right.size + 1;
            return new BSTInfo(size, true, Math.min(node.data, left.min), Math.max(node.data, right.max));
        } else {
            return new BSTInfo(
                    Math.max(left.size, right.size), false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    // Optimal Solution
    public int largestBST(TreeNode root) {
        return largestBSTHelper(root).maxSize;
    }

    private NodeValue largestBSTHelper(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if (left.maxNode < root.data && root.data < right.minNode) {
            // Current subtree is a valid BST
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        } else {
            // Current subtree is not a valid BST
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
        }
    }
}

class BSTInfo {
    int size;
    boolean isBST;
    int min;
    int max;

    BSTInfo(int size, boolean isBST, int min, int max) {
        this.size = size;
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}

class NodeValue {
    public int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}