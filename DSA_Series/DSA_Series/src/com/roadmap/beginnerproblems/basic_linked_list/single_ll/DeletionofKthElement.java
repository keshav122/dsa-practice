package com.roadmap.beginnerproblems.basic_linked_list.single_ll;

public class DeletionofKthElement {
    public ListNode deleteKthNode(ListNode head, int k) {
        int count = 1;
        if (k == 1) {
            return head.next;
        }
        ListNode curr = head;
        while (count < k - 1) {
            curr = curr.next;
            count++;
        }
        if (null != curr.next) {
            curr.next = curr.next.next;
        } else {
            curr.next = null;
        }
        return head;
    }
}
