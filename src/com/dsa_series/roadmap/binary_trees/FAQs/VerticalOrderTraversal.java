package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.*;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<NodeState> queue = new LinkedList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();
        queue.offer(new NodeState(root, 0, 0));
        while (!queue.isEmpty()) {
            NodeState nodeState = queue.poll();
            int position = nodeState.position;
            int level = nodeState.level;

            nodesMap.putIfAbsent(position, new TreeMap<>());
            nodesMap.get(position).putIfAbsent(level, new PriorityQueue<>());
            nodesMap.get(position).get(level).offer(nodeState.node.data);
            TreeNode node = nodeState.node;
            if (node.left != null)
                queue.offer(new NodeState(node.left, level + 1, nodeState.position - 1));
            if (node.right != null)
                queue.offer(new NodeState(node.right, level + 1, nodeState.position + 1));
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> levelMap : nodesMap.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levelMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            ans.add(column);
        }
        return ans;
    }
}

class NodeState {
    TreeNode node;
    int level;
    int position;

    NodeState(TreeNode node, int level, int position) {
        this.node = node;
        this.level = level;
        this.position = position;
    }
}
