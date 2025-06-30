package com.dsa_series.roadmap.beginnerproblems.basic_linked_list.single_ll;

/*Author: keshav122 */

public class DeletionOfHeadLL {
    public ListNode deleteHead(ListNode head) {
        ListNode newNode = head.next;
        head.next = null;
        return newNode;
    }
}
