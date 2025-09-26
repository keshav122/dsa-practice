package com.dsa_series.roadmap.tries.problems;

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

class OfficialSolution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }

        int maxi = 0;
        for (int num : nums) {
            maxi = Math.max(maxi, trie.getMax(num));
        }
        return maxi;
    }
}

public class MaxXOROfTwoNumberInArray {
    public int findMaximumXOR_BF(int[] nums) {
        int maxi = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                maxi = Math.max(maxi, xor);
            }
        }
        return maxi;
    }

}
