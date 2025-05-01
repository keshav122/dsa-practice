package com.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class InsertNodeBeforekthNode {
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
        if (K == 1) {
            ListNode newHead = new ListNode(X, head, null);
            head.prev = newHead;
            return newHead;
        }
        int count = 1;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while (count < K - 1) {
            currNode = currNode.next;
            nextNode = currNode.next;
            count++;
        }
        if (null != currNode) {
            ListNode newNode = new ListNode(X, nextNode, currNode);
            currNode.next = newNode;
            if (nextNode != null) {
                nextNode.prev = newNode;
            }
        }
        return head;
    }
}
