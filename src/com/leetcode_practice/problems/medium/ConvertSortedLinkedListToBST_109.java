
package com.leetcode_practice.problems.medium;

public class ConvertSortedLinkedListToBST_109 {

    public TreeNode sortedListToBST(ListNode head) {
        int len = getLenOfLL(head);
        return solve(0, len - 1, head);
    }

    private int getLenOfLL(ListNode head) {

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    private ListNode getElement(ListNode head, int idx) {
        int i = 0;
        ListNode temp = head;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    private TreeNode solve(int l, int r, ListNode head) {
        if (l > r)
            return null;
        int mid = l + ((r - l) >> 1);
        ListNode midElem = getElement(head, mid);
        TreeNode root = new TreeNode(midElem.val);
        root.left = solve(l, mid - 1, head);
        root.right = solve(mid + 1, r, head);
        return root;
    }
}