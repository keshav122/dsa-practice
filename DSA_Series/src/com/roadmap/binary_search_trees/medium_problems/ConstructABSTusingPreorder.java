package com.roadmap.binary_search_trees.medium_problems;

public class ConstructABSTusingPreorder {
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
