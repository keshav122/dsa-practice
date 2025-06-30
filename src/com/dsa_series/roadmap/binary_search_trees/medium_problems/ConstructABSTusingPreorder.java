package com.dsa_series.roadmap.binary_search_trees.medium_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructABSTusingPreorder {
    // In this approach we iterate through each of the nodes and place it at its
    // correct position
    public TreeNode bstFromPreorder_BF(int[] preorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = st.peek();
            TreeNode child = new TreeNode(preorder[i]);
            while (!st.isEmpty() && st.peek().data < preorder[i]) {
                node = st.pop();
            }
            if (node.data < preorder[i]) {
                node.right = child;
            } else {
                node.left = child;
            }

            st.push(child);
        }
        return root;
    }

    // In this approach we create a inorder array as we know that inorder array of
    // BST is sorted in non-decreasing fashion.
    // Then we can use the inorder and preorder to build BST as we had done in
    // Binary trees
    public TreeNode bstFromPreorder_Better(int[] preorder) {
        int n = preorder.length;
        int[] inorder = new int[n];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1, indexMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> indexMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = indexMap.get(root.data);
        int leftCount = rootIndex - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftCount, inorder, inStart, rootIndex - 1, indexMap);
        root.right = buildTree(preorder, preStart + leftCount + 1, preEnd, inorder, rootIndex + 1, inEnd, indexMap);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end)
            return null;
        TreeNode rootNode = new TreeNode(preorder[start]);
        int lefSubTreeEnd = start + 1;
        while (preorder[lefSubTreeEnd] < rootNode.data) {
            lefSubTreeEnd++;
        }
        rootNode.left = bstFromPreorder(preorder, start + 1, lefSubTreeEnd - 1);
        rootNode.right = bstFromPreorder(preorder, lefSubTreeEnd, end);
        return rootNode;
    }

    public TreeNode bstFromPreorder_Optimal(int[] preorder) {
        return bstFromPreorder_Optimal(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }

    private TreeNode bstFromPreorder_Optimal(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound)
            return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorder_Optimal(preorder, root.data, i);
        root.right = bstFromPreorder_Optimal(preorder, bound, i);
        return root;
    }
}
