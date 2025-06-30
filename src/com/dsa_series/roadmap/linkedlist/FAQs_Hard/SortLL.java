package com.dsa_series.roadmap.linkedlist.FAQs_Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLL {
    public ListNode sortList_BF(ListNode head) {
        if (null == head || null == head.next)
            return head;
        ListNode temp = head;
        List<Integer> li = new ArrayList<>();
        while (temp != null) {
            li.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(li);
        head = new ListNode(li.get(0));
        ListNode tempNode = head;
        for (int i = 1; i < li.size(); i++) {
            tempNode.next = new ListNode(li.get(i));
            tempNode = tempNode.next;
        }
        return head;
    }

    // Using mergeSort for LL
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next)
            return head;
        ListNode middleNode = findMiddle(head);
        ListNode leftHead = head, rightHead = middleNode.next;
        middleNode.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeTwoLists(leftHead, rightHead);

    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (null != list1) {
            res.next = list1;
        } else {
            res.next = list2;
        }
        return dummyNode.next;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
