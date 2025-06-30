package com.dsa_series.roadmap.linkedlist.FAQs_Medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoopInLL {
    public int findLengthOfLoop(ListNode head) {
        Map<ListNode, Integer> freqMap = new HashMap<>();
        ListNode temp = head;
        boolean isLoopPresent = false;
        while (temp != null) {
            freqMap.merge(temp, 1, Integer::sum);
            if (freqMap.get(temp) > 2) {
                isLoopPresent = true;
                break;
            }
            temp = temp.next;

        }
        if (isLoopPresent) {
            // Count = 1 because the first node will be having frequency 3
            int count = 1;
            for (Map.Entry<ListNode, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() == 2)
                    count++;
            }
            return count;
        }
        return 0;
    }

    public int findLengthOfLoop_Mapbetter(ListNode head) {
        Map<ListNode, Integer> visitedMap = new HashMap<>();
        ListNode temp = head;
        int timer = 1;
        while (temp != null) {
            if (visitedMap.containsKey(temp)) {
                return timer - visitedMap.get(temp);
            }
            visitedMap.put(temp, timer);
            timer++;
            temp = temp.next;

        }
        return 0;
    }

    public int findLengthOfLoop_Optimal(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // There is a cycle
                int count = 1;
                fast = fast.next;
                while (fast != slow) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }

}
