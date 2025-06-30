package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.*;

public class ZigZagOrSpiralTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                li.add(node.data);
            }
            level++;
            if (level % 2 == 0) {
                Collections.reverse(li);
            }
            res.add(li);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder_better(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> li = new ArrayList<>(Collections.nCopies(size, 0));
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        // Determine the index to insert the node's value based on the traversal direction
        int index = leftToRight ? i : (size - 1 - i);
        li.set(index, node.data);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      leftToRight = !leftToRight;
      res.add(li);
    }
    return res;
    }
}
