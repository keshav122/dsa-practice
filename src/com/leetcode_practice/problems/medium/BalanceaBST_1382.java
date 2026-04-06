/*Author: keshav122 */
package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBST_1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return solve(0, list.size() - 1, list);
    }

    private void inorder(TreeNode root, List<Integer> li) {
        if (null == root)
            return;
        inorder(root.left, li);
        li.add(root.val);
        inorder(root.right, li);
    }

    private TreeNode solve(int l, int r, List<Integer> list) {
        if (l > r)
            return null;
        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(list.get(mid));
        root.left = solve(l, mid - 1, list);
        root.right = solve(mid + 1, r, list);
        return root;
    }
}
