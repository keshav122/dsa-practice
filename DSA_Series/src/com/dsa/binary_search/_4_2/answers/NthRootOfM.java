package com.dsa.binary_search._4_2.answers;

public class NthRootOfM {

	public static int NthRoot(int n, int m) {
		for (int i = 1; i < m; i++) {
			int product = 1;
			for (int j = 1; j <= n; j++) {
				product *= i;
			}
			if (product == m)
				return i;
			if (product > m)
				return -1;
		}

		return -1;
	}
	
	public static int NthRoot_better(int n, int m) {
		for (int i = 1; i < m; i++) {
			int product = (int) Math.pow(i,n);//This takes logn while above one is O(n)
			if (product == m)
				return i;
			if (product > m)
				return -1;
		}

		return -1;
	}
	public static int NthRoot_1(int n, int m) {
		int low = 1;
		int high = m;
		while(low <= high) {
			int mid = (low + high)/2;
			long product = (long) Math.pow(mid, n);
			if (product == m) {
				return mid;	
			}else if(product < m) {
				low = mid + 1;
			}else {
				high = mid-1;
			}
		}

		return -1;
	}
	
	//returns a to power b in logarithmic time
	public static long power(int a , int b) {
		long ans = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				ans = ans * a;
				b = b-1;
			}else {
				a = a * a;
				b = b/2;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 9;
		int m = 1953125;
		System.out.println(NthRoot_1(n, m));
	}
}
