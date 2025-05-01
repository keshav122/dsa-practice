package com.roadmap.linkedlist.FAQs_Medium;

import java.util.HashMap;
import java.util.Map;

public class StartingPointInLL {
    public ListNode findStartingPoint(ListNode head) {
        Map<ListNode, Integer> freqMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (!freqMap.containsKey(temp)) {
                freqMap.merge(temp, 1, Integer::sum);
                temp = temp.next;
            } else {
                return temp;
            }

        }
        return temp;
    }

    // Two steps to this:
    // Check there is a loop or not
    // If yes move slow to the head and check for collision
    public ListNode findStartingPoint_Optimal(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // There is a cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }
}
