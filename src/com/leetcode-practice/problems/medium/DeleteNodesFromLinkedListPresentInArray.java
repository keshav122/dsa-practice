package com.leetcode-practice.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        boolean headFound = false;
        ListNode finalHeadNode = head;
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            if (!set.contains(currNode.val)) {
                if (!headFound) {
                    finalHeadNode = currNode;
                    headFound = true;
                }
                prevNode = currNode;
            } else {
                if (null != prevNode) {
                    prevNode.next = currNode.next;
                }
            }
            currNode = currNode.next;
        }

        return finalHeadNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}