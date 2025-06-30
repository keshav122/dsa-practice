package com.leetcode_practice.problems.medium;

import java.util.ArrayList;

public class FindMin_MaxNodesBWCriticalPoints_2058 {

	public int[] nodesBetweenCriticalPoints(ListNode head) {
		int currPos = 2;
		int ans[] = new int[2];
		ans[0] = ans[1] = -1;
		ArrayList<Integer> criticalPos = new ArrayList<>();
		ListNode prev = head;
		ListNode curr = head.next;
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
		while (curr.next != null) {
			ListNode next = curr.next;
			if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
				criticalPos.add(currPos);
                if(criticalPos.size() >= 2){
                  	minDiff = Math.min(minDiff, criticalPos.get(i) - criticalPos.get(i - 1));
                }
                i++;

			}
			prev = curr;
			curr = curr.next;
			currPos++;
		}
		
		if (minDiff != Integer.MAX_VALUE){
           ans[0] = minDiff;
           ans[1] = criticalPos.get(criticalPos.size() - 1) - criticalPos.get(0);
        }
			
		return ans;
	}
	
	public static void main(String[] args) {
		
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