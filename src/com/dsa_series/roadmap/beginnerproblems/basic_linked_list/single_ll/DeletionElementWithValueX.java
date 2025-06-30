package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.single_ll;

public class DeletionElementWithValueX {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        if (head.val == X) {
            return head.next;
        }
        ListNode currNode = head;
        ListNode prev = null;
        ListNode nextNode = currNode.next;
        while (currNode.next != null && currNode.val != X) {
            prev = currNode;
            currNode = currNode.next;
            nextNode = currNode.next;
        }
        if (currNode != null && currNode.val == X) {
            prev.next = nextNode;
        }
        return head;
    }
}
