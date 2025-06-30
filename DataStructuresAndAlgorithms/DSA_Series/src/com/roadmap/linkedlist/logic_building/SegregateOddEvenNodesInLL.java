/*Author: keshav122 */
/*Author: keshav122 */
package com.roadmap.linkedlist.logic_building;

public class SegregateOddEvenNodesInLL {
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode oddListTail = head;
        ListNode evenListHead = head.next;
        ListNode evenListTail = head.next;
        // The trick is to understand that we only need to check for even Nodes because
        // they will always be in front of the odd nodes. therefore if the even nodes
        // are not finished yet ,the odd nodes will surely not be null
        while (null != evenListTail && evenListTail.next != null) {
            oddListTail.next = oddListTail.next.next;
            oddListTail = oddListTail.next;
            evenListTail.next = evenListTail.next.next;
            evenListTail = evenListTail.next;
        }
        oddListTail.next = evenListHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        SegregateOddEvenNodesInLL seg = new SegregateOddEvenNodesInLL();
        ListNode res = seg.oddEvenList(l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

}
