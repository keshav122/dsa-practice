/*Author: keshav122 */
package com.roadmap.beginnerproblems.basic_linked_list.single_ll;

public class DeletionOfHeadLL {
    public ListNode deleteHead(ListNode head) {
        ListNode newNode = head.next;
        head.next = null;
        return newNode;
    }
}
