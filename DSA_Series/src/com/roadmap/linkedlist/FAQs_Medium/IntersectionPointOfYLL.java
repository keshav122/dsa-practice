package com.roadmap.linkedlist.FAQs_Medium;

import java.util.HashMap;
import java.util.Map;

public class IntersectionPointOfYLL {
    public ListNode getIntersectionNode_BF(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> freqMap = new HashMap<>();
        ListNode tempA = headA, tempB = headB;
        while (tempA != null) {
            freqMap.merge(tempA, 1, Integer::sum);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (freqMap.containsKey(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return tempB;
    }

    public ListNode getIntersectionNode_better(ListNode headA, ListNode headB) {
        if (null == headA || null == headB)
            return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = lenLL(tempA);
        int lenB = lenLL(tempB);
        if (lenA < lenB) {
            return findCollisionPoint(headA, headB, lenB - lenA);
        } else {
            return findCollisionPoint(headB, headA, lenA - lenB);
        }
    }

    private ListNode findCollisionPoint(ListNode smallerLenListHead, ListNode largerLenListHead, int d) {
        if (d > 0) {
            while (d > 0) {
                largerLenListHead = largerLenListHead.next;
                d--;
            }
        }
        while (largerLenListHead != null && smallerLenListHead != null) {
            if (largerLenListHead.val == smallerLenListHead.val) {
                return largerLenListHead;
            }
            largerLenListHead = largerLenListHead.next;
            smallerLenListHead = smallerLenListHead.next;
        }
        return largerLenListHead;
    }

    private int lenLL(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // In this approach also we are aligining the Linked lists so that we can
    // compare them
    // The only difference from the better approach is that we are not manually
    // removing the distance
    public ListNode getIntersectionNode_Optimal(ListNode headA, ListNode headB) {
        if (null == headA || null == headB)
            return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        // If the first head itself is equal we don't need to traverse
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA == tempB)
                return tempA;
            if (tempA == null)
                tempA = headB;
            if (tempB == null)
                tempB = headA;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode(7, new ListNode(8, new ListNode(4, new ListNode(5))));
        IntersectionPointOfYLL interesect = new IntersectionPointOfYLL();
        System.out.print(interesect.getIntersectionNode_Optimal(l1, l2).val);
    }
}
