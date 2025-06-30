package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class DeleteKthNodeDLL {
    public ListNode deleteKthElement(ListNode head, int k) {
        if (k == 1) {
            ListNode temp = head.next;
            if (head.next != null) {
                head.next.prev = null;
                head.next = null;
            }
            return temp;
        }
        int count = 1;
        ListNode temp = head;
        while (count < k) {
            head = head.next;
            count++;
        }
        head.prev.next = head.next;
        if (head.next != null) {
            head.next.prev = head.prev;
        }
        return temp;
    }
}
