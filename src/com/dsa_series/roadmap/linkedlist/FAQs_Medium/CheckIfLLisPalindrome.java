package com.dsa_series.roadmap.linkedlist.FAQs_Medium;

import java.util.Stack;

public class CheckIfLLisPalindrome {

    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != st.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        // TODO Attempt the solution
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        CheckIfLLisPalindrome check = new CheckIfLLisPalindrome();
        System.out.print(check.isPalindrome2(l1));
    }
}
