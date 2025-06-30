package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.single_ll;

public class InsertionBeforeXLL {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        // insertion at head
        if (head.val == X) {
            return new ListNode(val, head);
        }
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode.val != X && currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (null != currNode && currNode.val == X) {
            ListNode newNode = new ListNode(val, currNode);
            prevNode.next = newNode;
        }
        return head;
    }
}
