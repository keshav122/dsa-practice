package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class DeleteHeadOfLL {
    public ListNode deleteHead(ListNode head) {
        ListNode temp = head.next;
        if (head.next != null) {
            head.next.prev = null;
            head.next = null;
        }
        return temp;
    }
}
