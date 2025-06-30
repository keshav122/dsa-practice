package com.dsa_series.roadmap.linkedlist.logic_building;

public class SortAListOf0s1sAnd2s {
    public ListNode sortList_BF(ListNode head) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0)
                zeroCount++;
            else if (temp.val == 1)
                oneCount++;
            else
                twoCount++;
            temp = temp.next;
        }
        ListNode temp1 = head;
        while (temp1 != null) {
            int i = 1;
            while (i <= zeroCount) {
                temp1.val = 0;
                i++;
                temp1 = temp1.next;
            }
            i = 1;
            while (i <= oneCount) {
                temp1.val = 1;
                i++;
                temp1 = temp1.next;
            }
            i = 1;
            while (i <= twoCount) {
                temp1.val = 2;
                i++;
                temp1 = temp1.next;
            }
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode zeroHead = new ListNode(-1), zero = zeroHead;
        ListNode oneHead = new ListNode(-1), one = oneHead;
        ListNode twoHead = new ListNode(-1), two = twoHead;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.val == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }
}
