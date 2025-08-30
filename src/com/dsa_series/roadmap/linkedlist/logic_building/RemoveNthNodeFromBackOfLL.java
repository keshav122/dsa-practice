/*Author: keshav122 */
package com.dsa_series.roadmap.linkedlist.logic_building;

public class RemoveNthNodeFromBackOfLL {
    public ListNode removeNthFromEnd_BF(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int lenFromFront = len - n;
        int count = 0;
        ListNode temp1 = head;
        if (lenFromFront == 0)
            return temp1.next;
        while (count < lenFromFront) {
            if (count == lenFromFront - 1) {
                temp1.next = temp1.next.next;
            }
            count++;
            temp1 = temp1.next;
        }
        return head;
    }

    // The understanding here is that we keep two pointers : slow and fast
    // We keep the fast node, n nodes ahead of slow so when fast reaches the last
    // node
    // the slow reaches the node (Len of LL - N) node
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next; // in case n = len of LL or basically we have to delete the head
            // of LL
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
