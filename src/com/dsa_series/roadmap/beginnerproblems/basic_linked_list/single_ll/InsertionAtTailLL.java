package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.single_ll;

public class InsertionAtTailLL {
    public ListNode insertAtTail(ListNode head, int X) {
        if (head == null) {
            return new ListNode(X, null);
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(X, null);
        return head;
    }
}
