package com.dsa_series.roadmap.linkedlist.FAQs_DLL;

public class DeleteAllOccurencesOfKeyInDLL {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == target) {
                if (temp == head) {
                    head = head.next;
                }
                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;

    }
}
