package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.double_ll;

public class ConvertArraytoDLL {
    public ListNode arrayToLinkedList(int[] nums) {
        if (nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0], null, null);
        ListNode currNode = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i], null, currNode);
            currNode.next = newNode;
            currNode = newNode;
        }
        return head;
    }

}
