package com.dsa.arrays_3_3_hard;

import java.util.HashMap;
import java.util.Map;

public class MissingandRepeatingNumbers {

	public static int[] findMissingRepeatingNumbers_BruteForce(int[] a) {
		int ans[] = new int[2];
		for (int i = 1; i <= a.length; i++) {
			int count = 0;
			for (int j : a) {
				if (j == i) {
					count++;
				}
			}
			if (count == 0)
				ans[1] = i;
			if (count == 2)
				ans[0] = i;
			if (ans[0] != 0 && ans[1] != 0)
				return ans;
		}
		return ans;
	}

	public static int[] findMissingRepeatingNumbers(int[] a) {
		int hash[] = new int[a.length];
		int ans[] = new int[2];
		for (int i : a) {
			hash[i - 1]++;
		}

		for (int i = 0; i < hash.length; i++) {
			if (hash[i] == 0) {
				ans[1] = i + 1;
			}

			if (hash[i] == 2) {
				ans[0] = i + 1;
			}
		}

		return ans;
	}

	public static int[] findMissingRepeatingNumbers_better(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = a.length;
		int ans[] = new int[2];
		int repeat = 0;
		long sum = 0;
		for (int i : a) {
			if (map.containsKey(i)) {
				ans[0] = i;
				repeat = i;
				map.put(i, 2);
			} else {
				map.put(i, 1);
			}
			sum += i;
		}
		ans[1] = (int) (repeat + ((n * (n + 1)) / 2) - sum);
		return ans;
	}

	public static int[] findMissingRepeatingNumbers_optimal(int[] a) {
		int n = a.length;
		int ans[] = new int[2];
		long sum = (n * (n + 1)) / 2;
		long sumSquares = ((n * (n + 1) * (2 * n + 1))) / 6;
		long absSum = 0;
		long absSqSum = 0;
		for (int i : a) {
			absSum += i;
			absSqSum += (i * i);
		}
		long diff = (absSum - sum);
		long resSqDiff = (absSqSum - sumSquares) / diff;
		ans[0] = (int) (resSqDiff + diff) / 2;
		ans[1] = (int) (resSqDiff - ans[0]);
		return ans;
	}

	public static int[] findMissingRepeatingNumbers_optimalXORapproach(int[] a) {
		int ans[] = new int[2];
		int n = a.length;
		int xor = 0;
		for (int i = 0; i < a.length; i++) {
			xor ^= a[i];
			xor ^= (i + 1);
		}
		int bitNo = 0;
		while (true) {
			if ((xor & (1 << bitNo)) != 0) {
				break;
			}
			bitNo++;
		}

//		//The shorter way to generate the bitNumber of the differentiating bit is :
//		int bitNo = xor & ~(xor-1);//Bit Manipulation trick
		int zero = 0;
		int one = 0;

		for (int i = 0; i < n; i++) {
			// part of one club
			if ((a[i] & (1 << bitNo)) != 0) {
				one ^= a[i];
			}
			// part of zero club
			else {
				zero ^= a[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			// part of one club
			if ((i & (1 << bitNo)) != 0) {
				one ^= i;
			}
			// part of zero club
			else {
				zero ^= i;
			}
		}
		int count = 0;
		for (int i : a) {
			if (i == zero)
				count++;
		}
		if (count == 2) {
			ans[0] = zero;
			ans[1] = one;
			return ans;
		} else {
			ans[0] = one;
			ans[1] = zero;
			return ans;
		}
	}
	
	
	public static int[] findMissingRepeatingNumbers_optimalXORapproachCleaner(int[] a) {
		int ans[] = new int[2];
		int n = a.length;
		int xor = 0;
		for (int i = 0; i < a.length; i++) {
			xor ^= a[i];
			xor ^= (i + 1);
		}
		int number = xor & ~(xor-1);//Bit Manipulation trick
		int zero = 0;
		int one = 0;

		for (int i = 0; i < n; i++) {
			// part of one club
			if ((a[i] & (number)) != 0) {
				one ^= a[i];
			}
			// part of zero club
			else {
				zero ^= a[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			// part of one club
			if ((i & (number)) != 0) {
				one ^= i;
			}
			// part of zero club
			else {
				zero ^= i;
			}
		}
		int count = 0;
		for (int i : a) {
			if (i == zero)
				count++;
		}
		if (count == 2) {
			ans[0] = zero;
			ans[1] = one;
			return ans;
		} else {
			ans[0] = one;
			ans[1] = zero;
			return ans;
		}
	}

	public static void main(String[] args) {
		int n = 14;
		int a[] = { 10, 11, 1, 12, 3, 4, 13, 8, 2, 6, 7, 9, 5, 3 };
		int res[] = findMissingRepeatingNumbers_optimal(a);
		System.out.println("Missing :" + res[1] + " Repeat : " + res[0]);
	}
}
