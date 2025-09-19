package com.dsa_series.roadmap.tries.theory;

class Node {
    Node[] links = new Node[26];
    int cntEndWith = 0;
    int cntPrefix = 0;

    public Node() {
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void increaseEnd() {
        cntEndWith++;
    }

    void increasePrefix() {
        cntPrefix++;
    }

    void deleteEnd() {
        cntEndWith--;
    }

    void reducePrefix() {
        cntPrefix--;
    }

    int getEnd() {
        return cntEndWith;
    }

    int getPrefix() {
        return cntPrefix;
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
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return 0;
            } else {
                node = node.get(ch);
            }

        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return 0;
            } else {
                node = node.get(ch);
            }

        }
        return node.getPrefix();
    }

    // Assumption is that the word exists
    // as we have been asked to erase
    public void erase(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
                node.reducePrefix();
            } else {
                return;
            }

        }
        node.deleteEnd();
    }
}

public class TriesImplementationAndAdvancedoperations {

}
