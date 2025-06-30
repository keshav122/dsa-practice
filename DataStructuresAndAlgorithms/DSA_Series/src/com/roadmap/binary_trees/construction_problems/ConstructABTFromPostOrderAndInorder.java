package com.roadmap.binary_trees.construction_problems;

import java.util.HashMap;
import java.util.Map;

public class ConstructABTFromPostOrderAndInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int indexRoot = inorderMap.get(postorder[postEnd]);
        int numsLeft = indexRoot - inStart;
        TreeNode root = new TreeNode(inorder[indexRoot]);
        root.left = buildTree(inorder, inStart, indexRoot - 1, postorder, postStart, postStart + numsLeft - 1,
                inorderMap);
        root.right = buildTree(inorder, indexRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inorderMap);
        return root;
    }
}
