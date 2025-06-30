package com.leetcode_practice.problems.medium;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = lengthofLL(head);
        // If we have to remove head
        if (len == n) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        int distanceFromHead = len - n;
        int i = 1;
        ListNode temp = head;
        while (i < distanceFromHead) {
            temp = temp.next;
            i++;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            temp.next = null;
        }
        return head;

    }

    private int lengthofLL(ListNode head) {
        int count = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}