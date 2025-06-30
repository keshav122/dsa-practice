package com.dsa_series.roadmap.binary_trees.FAQs;

import java.util.*;

public class BottomViewOfBT {

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int pos = p.pos;

            map.putIfAbsent(pos, new LinkedList<>());
            LinkedList<Integer> li = map.get(pos);
            li.add(node.data);

            if (node.left != null) {
                queue.offer(new Pair(node.left, pos - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, pos + 1));
            }
        }

        for (List<Integer> li : map.values()) {
            ans.add(li.get(li.size() - 1));
        }
        return ans;
    }

    public List<Integer> bottomView_better(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 0));
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> entry = queue.poll();
            TreeNode node = entry.getKey();
            int pos = entry.getValue();
            map.put(pos, node.data);
            if (node.left != null)
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, pos - 1));
            if (node.right != null)
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, pos + 1));
        }

        for (Integer val : map.values()) {
            ans.add(val);
        }
        return ans;
    }
}

class Pair {
    TreeNode node;
    int pos;

    Pair(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}
