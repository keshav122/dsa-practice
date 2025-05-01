package com.roadmap.linkedlist.FAQs_Hard;

import java.util.HashMap;
import java.util.Map;

public class CloneLLWithnext_And_randomPt {
    public ListNode copyRandomList_BF(ListNode head) {
        Map<ListNode, ListNode> nodeMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            nodeMap.put(temp, new ListNode(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            ListNode currNode = nodeMap.get(temp);
            currNode.next = nodeMap.get(temp.next);
            currNode.random = nodeMap.get(temp.random);
            temp = temp.next;
        }
        return nodeMap.get(head);
    }

    public ListNode copyRandomList_Optimal(ListNode head) {
        // Inserting nodes in the middle
        ListNode temp = head;
        while (temp != null) {
            ListNode copyNode = new ListNode(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next;
        }

        // Connecting the random pointers
        temp = head;
        while (temp != null) {
            ListNode copiedNode = temp.next;
            if (null != temp.random) {
                copiedNode.random = temp.random.next;
            } else {
                copiedNode.random = null;
            }

            temp = temp.next.next;
        }

        // Connecting the next pointer and extracting the list
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        temp = head;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode() {
        val = 0;
        next = null;
        random = null;
    }

    ListNode(int val) {
        this.val = val;
        next = null;
        random = null;
    }

    ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}