package com.dsa_series.roadmap.linkedlist.FAQs_Medium;

/*Author: keshav122 */

public class DeleteTheMiddleNodeInLL {
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int halfLen = lenLL(temp) / 2;
        if (halfLen == 0) {
            return null;
        }
        int count = 1;
        while (count < halfLen) {
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
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

    public ListNode deleteMiddle_Better(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slowPrev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPrev.next = slow.next;
        return head;
    }

    public ListNode deleteMiddle_Optimal(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        DeleteTheMiddleNodeInLL deleteMiddleNode = new DeleteTheMiddleNodeInLL();
        ListNode head = deleteMiddleNode.deleteMiddle(l1);
        while (head != null) {
            System.out.print(head.val + " ");
        }
        System.out.println();
    }
}
