package com.dsa_series.roadmap.linkedlist.logic_building;

public class AddTwoNumbersInLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1, tail = l1;
        while (l1 != null && l2 != null) {
            int temp = l1.val;
            l1.val = (l1.val + l2.val + carry) % 10;
            carry = (temp + l2.val + carry) / 10;// Do not use l1.val as the value will be changed in line 10
            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int temp = l1.val;
            l1.val = (l1.val + carry) % 10;
            carry = (temp + carry) / 10;
            tail = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            tail = tail.next;
        }
        if (tail != null && carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4, new ListNode(5, new ListNode(6)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        AddTwoNumbersInLL add = new AddTwoNumbersInLL();
        ListNode res = add.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

}
