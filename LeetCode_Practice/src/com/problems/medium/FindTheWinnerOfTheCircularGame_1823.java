/*Author: keshav122 */
package com.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame_1823 {

	public int findTheWinner(int n, int k) {
		List<Integer> li = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			li.add(i);
		}
		int count = n;
		int sI = 0;
		while (count > 1) {
			int val = (sI + k) % n;
			if (li.contains(Integer.valueOf(val))) {
				li.remove(Integer.valueOf(val));
				sI = val;
			}
			count--;
		}
		return li.get(0);
	}

	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		FindTheWinnerOfTheCircularGame_1823 obj = new FindTheWinnerOfTheCircularGame_1823();
		System.out.println(obj.findTheWinner(n, k));
	}
}
