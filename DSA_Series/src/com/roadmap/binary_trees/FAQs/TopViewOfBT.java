package com.roadmap.binary_trees.FAQs;

import java.util.*;

public class TopViewOfBT {
    public List<Integer> topView(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, LinkedList<Integer>> posNodeMap = new TreeMap<>();
        queue.offer(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int level = tuple.level;
            int pos = tuple.pos;

            posNodeMap.putIfAbsent(pos, new LinkedList<>());
            LinkedList<Integer> li = posNodeMap.get(pos);
            li.add(node.data);
            posNodeMap.put(pos, li);
            if (node.left != null)
                queue.offer(new Tuple(node.left, pos - 1, level + 1));
            if (node.right != null)
                queue.offer(new Tuple(node.right, pos + 1, level + 1));
        }
        List<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, LinkedList<Integer>> entry : posNodeMap.entrySet()) {
            list.add(entry.getValue().get(0));
        }
        return list;
    }

    public List<Integer> topView_better(TreeNode root) {
        Queue<Tuple2> queue = new LinkedList<>();
        TreeMap<Integer, Integer> posValueMap = new TreeMap<>();
        queue.offer(new Tuple2(root, 0));
        while (!queue.isEmpty()) {
            Tuple2 tuple = queue.poll();
            TreeNode node = tuple.node;
            int pos = tuple.pos;
            // Line 14-16: Add a comment to explain that the first node at each horizontal
            // distance is added to the map.
            if (!posValueMap.containsKey(pos)) {
                posValueMap.put(pos, node.data);
            }

            if (node.left != null)
                queue.offer(new Tuple2(node.left, pos - 1));
            if (node.right != null)
                queue.offer(new Tuple2(node.right, pos + 1));
        }
        List<Integer> list = new LinkedList<>();
        for (Integer val : posValueMap.values()) {
            list.add(val);
        }
        return list;
    }
}

class Tuple {
    TreeNode node;
    int pos;
    int level;

    Tuple(TreeNode node, int pos, int level) {
        this.node = node;
        this.pos = pos;
        this.level = level;
    }
}

class Tuple2 {
    TreeNode node;
    int pos;

    Tuple2(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}