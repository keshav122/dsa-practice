package com.roadmap.basic_linked_list;

public class DeletionOfHeadLL {
    public ListNode deleteHead(ListNode head) {
        ListNode newNode = head.next;
        head.next = null;
        return newNode;
    }
}
