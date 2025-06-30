package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.single_ll;

public class InsertionAtKLL {
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        // Handling insertion at head
        if (K == 1 || head == null) {
            return new ListNode(X, head);
        }
        int count = 1;
        ListNode currNode = head;
        ListNode nextNode = currNode.next;
        while (count < K - 1) {
            currNode = currNode.next;
            nextNode = currNode.next;
            count++;
        }
        if (null != currNode) {
            currNode.next = new ListNode(X, nextNode);
        }
        return head;
    }
}
