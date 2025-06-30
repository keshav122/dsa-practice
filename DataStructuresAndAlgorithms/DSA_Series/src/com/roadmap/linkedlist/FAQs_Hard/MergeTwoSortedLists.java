package com.roadmap.linkedlist.FAQs_Hard;

/*# Author: keshav122*/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = null, traversalNode = null, l1Curr = list1, l2Curr = list2;
        while (l1Curr != null && l2Curr != null) {
            if (l1Curr.val <= l2Curr.val) {
                if (head == null) {
                    head = l1Curr;
                } else {
                    traversalNode.next = l1Curr;
                }
                traversalNode = l1Curr;
                l1Curr = l1Curr.next;

            } else {
                if (head == null) {
                    head = l2Curr;
                } else {
                    traversalNode.next = l2Curr;
                }
                traversalNode = l2Curr;
                l2Curr = l2Curr.next;
            }
        }

        while (l1Curr != null) {
            traversalNode.next = l1Curr;
            traversalNode = l1Curr;
            l1Curr = l1Curr.next;
        }

        while (l2Curr != null) {
            traversalNode.next = l2Curr;
            traversalNode = l2Curr;
            l2Curr = l2Curr.next;
        }
        return head;
    }

    public ListNode mergeTwoLists_better(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = new ListNode(-1), temp = head, l1 = list1, l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            temp.next = l1;
            temp = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.next = l2;
            temp = l2;
            l2 = l2.next;
        }
        return head.next;
    }
}
