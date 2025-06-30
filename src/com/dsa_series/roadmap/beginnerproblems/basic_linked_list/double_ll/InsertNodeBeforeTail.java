package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.double_ll;

/* # Author: keshav122*/
public class InsertNodeBeforeTail {

    public ListNode insertBeforeTail(ListNode head, int X) {
        if (head.next == null) {
            ListNode newHead = new ListNode(X, head, null);
            head.prev = newHead;
            return newHead;
        }
        ListNode temp = head;
        while (head.next.next != null) {
            head = head.next;
        }
        ListNode newNode = new ListNode(X, head.next, head);
        head.next.prev = newNode;
        head.next = newNode;
        return temp;
    }
}
