package com.dsa_series.roadmap.tries.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            // Extract ith bit
            int bit = (num >> i) & 1;
            /* If the current node doesn't have a child node with the current bit */
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    // Method to find the maximum XOR
    int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            /*
             * If the complement of the current bit exists in the Trie
             * update the maximum XOR value with the current bit , move to the child node
             * corresponding to the complement of the current bit
             * Else move to the child node corresponding to the current bit
             */

            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

public class MaximumXORWithAnElementFromArray {
    public List<Integer> maximizeXor_BF(int[] nums, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int maxi = -1;
            int x = query[0];
            int m = query[1];
            for (int num : nums) {
                if (num <= m) {
                    maxi = Math.max(maxi, num ^ x);
                }
            }
            ans.add(maxi);
        }
        return ans;
    }

    public List<Integer> maximizeXor(int[] nums, int[][] queries) {
        Integer[] ans = new Integer[queries.length];
        List<int[]> offlineQueries = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            offlineQueries.add(new int[] { queries[i][1], queries[i][0], i });
        }

        // Sort queries based on their end points
        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        int i = 0;
        Trie trie = new Trie();

        // Process each query
        for (int[] query : offlineQueries) {
            while (i < nums.length && nums[i] <= query[0]) {
                trie.insert(nums[i]);
                i++;
            }

            if (i != 0) {
                ans[query[2]] = trie.getMax(query[1]);
            } else {
                ans[query[2]] = -1;
            }
        }
        return Arrays.asList(ans);
    }

}
