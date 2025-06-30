package com.dsa_series.roadmap.linkedlist.FAQs_Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class FlatteningOfLL {
    public ListNode flattenLinkedList_BF(ListNode head) {
        List<Integer> li = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            ListNode childHead = temp;
            while (childHead != null) {
                li.add(childHead.val);
                childHead = childHead.child;
            }
            temp = temp.next;
        }
        Collections.sort(li);
        return convertListToChildLL(li);
    }

    private ListNode convertListToChildLL(List<Integer> li) {
        if (li.size() == 0)
            return null;
        ListNode head = new ListNode(li.get(0));
        ListNode temp = head;
        for (int i = 1; i < li.size(); i++) {
            temp.child = new ListNode(li.get(i));
            temp = temp.child;
        }
        return head;
    }

    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode smallHead = flattenLinkedList(head.next);
        head = mergeList(head, smallHead);
        return head;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
