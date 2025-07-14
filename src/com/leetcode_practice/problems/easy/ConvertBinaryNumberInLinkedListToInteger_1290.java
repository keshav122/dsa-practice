package com.leetcode_practice.problems.easy;

public class ConvertBinaryNumberInLinkedListToInteger_1290 {

    public int getDecimalValue_optimal(ListNode head) {
        head = reverseListNode(head);
        ListNode temp = head;
        int sum = 0;
        int i = 0;
        while (temp != null) {
            sum += temp.val * Math.pow(2, i);
            i++;
            temp = temp.next;
        }
        return sum;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public int getDecimalValue(ListNode head) {
        int digits = 0;
        int currVal = 0;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            digits++;
        }
        temp = head;
        while (temp != null) {
            currVal += (temp.val) * (1 << digits);
            temp = temp.next;
            digits--;
        }
        return currVal;
    }
}