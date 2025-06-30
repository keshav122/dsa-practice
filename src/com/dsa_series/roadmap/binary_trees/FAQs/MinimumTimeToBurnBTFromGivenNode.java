package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumTimeToBurnBTFromGivenNode {

    public int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode target = parentTracker(root, parentMap, start);
        int maxDist = findMaxDistance(parentMap, target);
        return maxDist;
    }

    private int findMaxDistance(Map<TreeNode, TreeNode> parentMap, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode, Integer> visited = new HashMap<>();
        visited.put(target, 1);
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int nodesBurnt = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    nodesBurnt = 1;
                    visited.put(node.left, 1);
                    q.offer(node.left);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    nodesBurnt = 1;
                    visited.put(node.right, 1);
                    q.offer(node.right);
                }
                if (parentMap.get(node) != null && visited.get(parentMap.get(node)) == null) {
                    nodesBurnt = 1;
                    visited.put(parentMap.get(node), 1);
                    q.offer(parentMap.get(node));
                }
            }
            if (nodesBurnt == 1)
                max++;
        }
        return max;
    }

    private TreeNode parentTracker(TreeNode root, Map<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode.data == start)
                res = currNode;
            if (currNode.left != null) {
                parentMap.put(currNode.left, currNode);
                q.offer(currNode.left);
            }
            if (currNode.right != null) {
                parentMap.put(currNode.right, currNode);
                q.offer(currNode.right);
            }
        }
        return res;
    }
}