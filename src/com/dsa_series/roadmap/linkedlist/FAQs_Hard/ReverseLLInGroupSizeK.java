package com.dsa_series.roadmap.linkedlist.FAQs_Hard;

public class ReverseLLInGroupSizeK {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempNode = head, nextNode = null, prevNode = null;
        while (tempNode != null) {
            ListNode kthNode = findKthNode(tempNode, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = tempNode;
                }

                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(tempNode);
            if (tempNode == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = tempNode;
            tempNode = nextNode;
        }
        return head;
    }

    private ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        k -= 1;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
