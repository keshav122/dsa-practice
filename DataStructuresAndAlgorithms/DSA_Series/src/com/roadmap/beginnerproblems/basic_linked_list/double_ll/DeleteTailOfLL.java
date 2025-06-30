package com.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class DeleteTailOfLL {
    public ListNode deleteTail(ListNode head) {
        if (head.next == null)
            return null;
        ListNode temp = head;
        while (head.next.next != null) {
            head = head.next;
        }
        head.next.prev = null;
        head.next = null;
        return temp;
    }
}
