package com.roadmap.binary_trees.construction_problems;

import java.util.HashMap;
import java.util.Map;

public class ConstructUniqueBTFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int indexRoot = inorderMap.get(root.data);
        int numsLeft = indexRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, indexRoot - 1, inorderMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, indexRoot + 1, inEnd, inorderMap);
        return root;
    }
}
