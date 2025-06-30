package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class DeleteGivenNode {
    public void deleteGivenNode(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
    }
}
