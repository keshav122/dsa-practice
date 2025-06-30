package com.roadmap.linkedlist.FAQs_DLL;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatedFromSortedLL {

    public ListNode removeDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.isEmpty()) {
                set.add(temp.val);
                temp = temp.next;
            } else {
                if (set.contains(temp.val)) {
                    ListNode prevNode = temp.prev;
                    ListNode nextNode = temp.next;
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    }
                    if (nextNode != null) {
                        nextNode.prev = prevNode;
                    }
                    temp = nextNode;
                } else {
                    set.add(temp.val);
                    temp = temp.next;
                }
            }
        }
        return head;
    }

    public ListNode removeDuplicates_Optimal(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;
            while (nextNode != null && nextNode.val == temp.val) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
