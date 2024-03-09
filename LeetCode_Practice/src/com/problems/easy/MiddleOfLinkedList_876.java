package com.problems.easy;

public class MiddleOfLinkedList_876 {
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head;
		int len = 1;
		while (temp.next != null) {
			temp = temp.next;
			len++;
		}
		int val = len / 2;
		while (val > 0) {
			head = head.next;
			val--;
		}
		return head;
	}
}
