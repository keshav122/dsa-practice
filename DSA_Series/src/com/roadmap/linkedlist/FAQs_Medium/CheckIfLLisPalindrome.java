package com.roadmap.linkedlist.FAQs_Medium;

public class CheckIfLLisPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode headNode = head;
        ListNode revLL = reverseLL(head);
        while (headNode != null) {
            if (headNode.val != revLL.val) {
                return false;
            }
            headNode = headNode.next;
            revLL = revLL.next;
        }
        return true;
    }

    private ListNode reverseLL(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        CheckIfLLisPalindrome check = new CheckIfLLisPalindrome();
        System.out.print(check.isPalindrome(l1));
    }
}
