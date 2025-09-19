package com.dsa_series.roadmap.tries.theory;

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

public class TriesImplementationAndOperations {

}
