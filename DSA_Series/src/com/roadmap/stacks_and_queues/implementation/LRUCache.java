package com.roadmap.stacks_and_queues.implementation;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, DoubleLLNode> nodeMap;
    DoubleLLNode dummyHead, dummyTail;
    int totalCap;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>();
        dummyHead = new DoubleLLNode();
        dummyTail = new DoubleLLNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        totalCap = capacity;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            DoubleLLNode node = nodeMap.get(key);
            int val = node.value;
            deleteNode(node);
            insertAfterHead(node);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            DoubleLLNode node = nodeMap.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
            return;
        }
        if (nodeMap.size() == totalCap) {
            DoubleLLNode prevOfTailNode = dummyTail.prev;
            nodeMap.remove(prevOfTailNode.key);
            deleteNode(prevOfTailNode);
        }
        DoubleLLNode newNode = new DoubleLLNode(key, value);
        nodeMap.put(key, newNode);
        insertAfterHead(newNode);
    }

    private void insertAfterHead(DoubleLLNode node) {
        DoubleLLNode currHeadNext = dummyHead.next;
        dummyHead.next = node;
        currHeadNext.prev = node;
        node.next = currHeadNext;
        node.prev = dummyHead;
    }

    private void deleteNode(DoubleLLNode node) {
        DoubleLLNode prevNode = node.prev;
        DoubleLLNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

class DoubleLLNode {
    int key;
    int value;
    DoubleLLNode next;
    DoubleLLNode prev;

    DoubleLLNode() {
        key = value = -1;
        next = prev = null;
    }

    DoubleLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
