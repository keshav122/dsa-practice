package com.dsa_series.roadmap.tries.problems;

import java.util.List;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {

    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {

    private Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            // move to the reference trie
            node = node.get(ch);
        }
        node.setEnd();
    }

    boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

}

public class LongestWordWithAllPrefixes {
    public String completeString(List<String> nums) {
        Trie trie = new Trie();
        for (String num : nums) {
            trie.insert(num);
        }

        String ans = "";
        for (String num : nums) {
            boolean allPrefixesFound = true;
            for (int i = 0; i < num.length(); i++) {
                if (!trie.search(num.substring(0, i + 1))) {
                    allPrefixesFound = false;
                    break;
                }
            }
            if (allPrefixesFound) {
                if (num.length() > ans.length()) {
                    ans = num;
                } else if (num.length() == ans.length() && ans.compareTo(num) > 0) {
                    ans = num;
                }
            }
        }
        if (ans == "")
            return "None";
        return ans;

    }
}

class TrieOfficial {

    private Node root;

    TrieOfficial() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            // move to the reference trie
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean checkIfAllPrefixExists(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            } else {
                node = node.get(ch);
                if (!node.isEnd())
                    return false;
            }

        }
        return true;
    }
}

class Solution {
    public String completeString(List<String> nums) {
        TrieOfficial trie = new TrieOfficial();
        for (String num : nums) {
            trie.insert(num);
        }

        String longest = "";
        for (String num : nums) {
            if (trie.checkIfAllPrefixExists(num)) {
                if (num.length() > longest.length()) {
                    longest = num;
                } else if (num.length() == longest.length() && longest.compareTo(num) > 0) {
                    longest = num;
                }
            }
        }
        if (longest == "")
            return "None";
        return longest;

    }
}