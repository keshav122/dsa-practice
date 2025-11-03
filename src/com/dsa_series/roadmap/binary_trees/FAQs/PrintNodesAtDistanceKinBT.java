/*Author: keshav122 */
package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.*;

public class PrintNodesAtDistanceKinBT {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentTracker(root, parentMap);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int cur_dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (cur_dist == k)
                break;
            cur_dist++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parentMap.get(current) != null && visited.get(parentMap.get(current)) == null) {
                    queue.offer(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            res.add(current.data);
        }
        return res;
    }

    private void parentTracker(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode.left != null) {
                parentMap.put(currNode.left, currNode);
                q.offer(currNode.left);
            }
            if (currNode.right != null) {
                parentMap.put(currNode.right, currNode);
                q.offer(currNode.right);
            }
        }
    }
}
