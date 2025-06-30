package com.dsa_series.roadmap.linkedlist.logic_building;

public class ReverseALL {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6, new ListNode(8));
        ReverseALL rev = new ReverseALL();
        ListNode res = rev.reverseList(l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
