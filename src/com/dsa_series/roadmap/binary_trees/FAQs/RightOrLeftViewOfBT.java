package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class RightOrLeftViewOfBT {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        // We just want the rightmost node of each level
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        // This will store level and the corresponding node for it , as the rightmost
        // node will be the last to enter
        Map<Integer, Integer> map = new TreeMap<>();
        if (root == null)
            return ans; // Line 22: Added handling for null root
        q.add(new AbstractMap.SimpleEntry<>(root, 0));
        while (!q.isEmpty()) {
            Map.Entry<TreeNode, Integer> entry = q.poll();
            TreeNode node = entry.getKey();
            int level = entry.getValue();
            map.put(level, node.data);
            if (node.left != null)
                q.add(new AbstractMap.SimpleEntry<>(node.left, level + 1));
            if (node.right != null)
                q.add(new AbstractMap.SimpleEntry<>(node.right, level + 1));
        }

        for (Integer val : map.values()) {
            ans.add(val);
        }
        return ans;

    }

    public List<Integer> rightSideView_recursive(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        rightSideViewHelper(root, ans, 0);
        return ans;
    }

    private void rightSideViewHelper(TreeNode root, List<Integer> list, int level) {
        if (null == root)
            return;
        if (list.size() == level) {
            list.add(root.data);
        }
        rightSideViewHelper(root.right, list, level + 1);
        rightSideViewHelper(root.left, list, level + 1);
    }
}
