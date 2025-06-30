package com.dsa_series.roadmap.linkedlist.FAQs_Medium;

import java.util.HashMap;
import java.util.Map;

public class DetectALoopInLL {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> freqMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (!freqMap.containsKey(temp)) {
                freqMap.merge(temp, 1, Integer::sum);
                temp = temp.next;
            } else {
                return true;
            }

        }
        return false;
    }

    public boolean hasCycle_Optimal(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(7, new ListNode(4)))));
        DetectALoopInLL detect = new DetectALoopInLL();
        System.out.print(detect.hasCycle(l1));
    }
}
