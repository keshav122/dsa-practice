package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.single_ll;

public class DeletionOfTailLL {
    public ListNode deleteTail(ListNode head) {
        ListNode result = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (head.next.next != null) {
            head = head.next;
        }
        head.next = null;
        return result;
    }
}
