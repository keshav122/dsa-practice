package com.dsa_series.roadmap.tries.problems;

import java.util.HashSet;
import java.util.Set;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {
    }

    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    boolean isEnd() {
        return flag;
    }

    void setEnd() {
        flag = true;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }
}

class Solution {
    public int countDistinctSubstring(String s) {
        Trie trie = new Trie();
        int n = s.length();
        int count = 1;// for empty string
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substr = s.substring(i, j + 1);
                if (!trie.search(substr)) {
                    trie.insert(substr);
                    count++;
                }
            }
        }
        return count;
    }
}

// We can also do it without using the Trie class and only using the Node class
public class NumberOfDistinctSubstringsInAString {

    // Set Based Solution
    public int countDistinctSubstring_BF(String s) {
        int n = s.length();
        Set<String> uniqueSubStrSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = i; j < n; j++) {
                str += s.charAt(j);
                uniqueSubStrSet.add(str);
            }
        }
        return uniqueSubStrSet.size() + 1;
    }

    public int countDistinctSubstring(String s) {
        int count = 0;
        Node root = new Node();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Node node = root;
            // Iterate through characters of substring starting at i
            for (int j = i; j < n; j++) {
                char currentChar = s.charAt(j);
                if (!node.containsKey(currentChar)) {
                    count++;
                    node.put(currentChar, new Node());
                }
                // Move to the child node
                node = node.get(currentChar);
            }
        }
        // + 1 for the empty substring
        return count + 1;
    }
}
