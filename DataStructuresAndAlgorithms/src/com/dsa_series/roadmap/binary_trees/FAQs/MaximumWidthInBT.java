package com.roadmap.binary_trees.FAQs;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthInBT {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<NodeIndexPair> q = new LinkedList<>();
        q.offer(new NodeIndexPair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int levelMin = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                NodeIndexPair currPair = q.poll();
                TreeNode node = currPair.node;
                int curNum = currPair.num - levelMin;
                if (i == 0) {
                    first = curNum;
                }

                if (i == size - 1) {
                    last = curNum;
                }

                if (node.left != null) {
                    q.offer(new NodeIndexPair(node.left, curNum * 2 + 1));
                }

                if (node.right != null) {
                    q.offer(new NodeIndexPair(node.right, curNum * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}

class NodeIndexPair {
    TreeNode node;
    int num;

    NodeIndexPair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
