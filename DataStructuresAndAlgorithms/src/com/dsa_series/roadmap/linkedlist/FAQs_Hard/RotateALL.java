package com.roadmap.linkedlist.FAQs_Hard;

public class RotateALL {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }
        int len = lenLL(head);
        k %= len;
        if (k % len == 0) {
            return head;
        }
        ListNode revHead = reverseLL(head);
        ListNode kthNode = findKthNode(revHead, k);
        ListNode nextNode = kthNode.next;
        kthNode.next = null;
        reverseLL(revHead);
        head = kthNode;
        revHead.next = reverseLL(nextNode);
        return head;
    }

    private ListNode findKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private int lenLL(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight_OptimalOfficial(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        if (k % length == 0) {
            return head;
        }
        k %= length;
        tail.next = head;
        ListNode newLastNode = findNthNode(head, length - k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

    private ListNode findNthNode(ListNode head, int len) {
        for (int i = 1; i <= len; i++) {
            head = head.next;
        }
        return head;
    }
}
