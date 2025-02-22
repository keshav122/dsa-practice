package com.roadmap.stacks_and_queues.FAQs;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    // HashMap to store key-node pairs in least recently used order
    Map<Integer, Node> keyNodeMap;
    Map<Integer, List> freqListMap;
    int maxSizeCache;
    /*
     * To store the frequency of least
     * frequently used data-item
     */
    int minFreq;
    int currSize;

    public LFUCache(int capacity) {
        keyNodeMap = new HashMap<>();
        freqListMap = new HashMap<>();
        maxSizeCache = capacity;
        currSize = 0;
        minFreq = 0;
    }

    // Method to update frequency of data-items
    private void updateFreqListMap(Node node) {
        keyNodeMap.remove(node.key);
        // Update the frequency list hashmap
        freqListMap.get(node.freq).removeNode(node);
        // If node was the last node having its frequency
        if (node.freq == minFreq && freqListMap.get(node.freq).size == 0) {
            // Update the min freq
            minFreq++;
        }
        // Creating a dummy list for next higher frequency
        List nextHigherFreqList = new List();

        // If the next higher frequency list already exists
        if (freqListMap.containsKey(node.freq + 1)) {
            nextHigherFreqList = freqListMap.get(node.freq + 1);
        }
        node.freq += 1;
        nextHigherFreqList.addFront(node);
        freqListMap.put(node.freq, nextHigherFreqList);
        keyNodeMap.put(node.key, node);
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        } else {
            Node node = keyNodeMap.get(key);
            int val = node.value;
            updateFreqListMap(node);
            return val;
        }
    }

    public void put(int key, int value) {
        if (maxSizeCache == 0) {
            return;
        }
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {
            if (currSize == maxSizeCache) {
                // Remove the least frequently used data-item
                List list = freqListMap.get(minFreq);
                // Remove the last recently used item from the least frequency list
                keyNodeMap.remove(list.tail.prev.key);
                freqListMap.get(minFreq).removeNode(list.tail.prev);
                currSize--;
            }
            // Increment the current cache size
            currSize++;

            // Adding new value to the cache
            minFreq = 1; // Set its frequency to 1
            List listFreq = new List();
            if (freqListMap.containsKey(minFreq)) {
                listFreq = freqListMap.get(minFreq);
            }
            Node node = new Node(key, value);
            listFreq.addFront(node);
            keyNodeMap.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }
}

class Node {
    int key, value, freq;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class List {
    int size;
    Node head;
    Node tail;

    List() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // To add node in front
    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        head.next = node;
        temp.prev = node;
        node.prev = head;
        size++;
    }

    void removeNode(Node deleteNode) {
        Node prevNode = deleteNode.prev;
        Node nextNode = deleteNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}
