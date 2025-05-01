package com.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class InsertBeforeGivenNodeDLL {
    public void insertBeforeGivenNode(ListNode node, int X) {
        ListNode prevNode = node.prev;
        ListNode newNode = new ListNode(X, node, prevNode);
        prevNode.next = newNode;
        node.prev = newNode;
    }
}
