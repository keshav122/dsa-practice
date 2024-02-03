package com.dsa.basic_1_4.basic_maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllDivisors {

	public static List<Integer> printDivisors(int n) {
		List<Integer> li = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				li.add(i);
			}
		}
		return li;
	}

	public static List<Integer> printDivisors_Way2(int n) {
		 List<Integer> li = new ArrayList<>();
		 //Rather than using function , check if there is possibility to save time for rather 
		 //than doing i <= Math.sqrt(n) , try to use i * i <= n
			for(int i = 1; i* i <= n ; i++) {
				if(n % i == 0) {
					li.add(i);
					int quotient = n/i;
					if(quotient != i) {
						li.add(quotient);
					}
				}
			}
			Collections.sort(li);
			return li;
	}

	public static List<Integer> printDivisors_way1(int n) {
		Set<Integer> set = new HashSet<>();
		int start = 1;
		set.add(1);
		set.add(n);
		int end = n;
		start++;
		while (start <= end) {
			if (n % start == 0) {
				set.add(start);
				set.add(n / start);
				end = n / start;
				start++;
			} else {
				start++;
			}
		}
		List<Integer> li = new ArrayList<>();
		for (Integer i : set) {
			li.add(i);
		}
		Collections.sort(li);
		return li;
	}

	public static void main(String[] args) {
		int n = 10;
		List<Integer> ans = printDivisors(n);
		System.out.println(ans.toString());
	}
}
