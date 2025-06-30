package com.roadmap.linkedlist.FAQs_Medium;

public class AddOneToANumberInLL {

    public ListNode addOne_1(ListNode head) {
        if (null == head)
            return head;
        int carry = 1;
        ListNode tempRevHead = reverseLL(head);
        ListNode temp = tempRevHead, tail = tempRevHead;
        while (temp != null) {
            int value = temp.val;
            temp.val = (value + carry) % 10;
            carry = (value + carry) / 10;
            tail = temp;
            temp = temp.next;
        }
        if (tail != null && carry != 0) {
            tail.next = new ListNode(carry);
        }
        return reverseLL(tempRevHead);
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

    public ListNode addOne(ListNode head) {
        int carry = helper(head);
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public int helper(ListNode head) {
        if (null == head) {
            return 1;
        }
        int carry = helper(head.next);
        head.val = head.val + carry;
        if (head.val < 10) {
            return 0;
        }
        head.val = 0;
        return 1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        AddOneToANumberInLL add = new AddOneToANumberInLL();
        ListNode res = add.addOne(l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
