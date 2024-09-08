package com.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class InsertBeforeHeadDLL {
    public ListNode insertBeforeHead(ListNode head, int X) {
        ListNode newHead = new ListNode(X, head, null);
        head.prev = newHead;
        return newHead;
    }
}
