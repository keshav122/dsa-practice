package com.problems.easy;

public class MissingNumber_268 {

	public int missingNumber_BruteForce(int[] nums) {
		int n = nums.length;
		for (int i = 0; i <= n; i++) {
			int flag = 0;
			for (int j = 0; j < n; j++) {
				if (nums[j] == i) {
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				return i;
		}
		return 0;
	}

	// Create a hash array
	public int missingNumber_BetterSolution(int[] nums) {
		int n = nums.length;
		int hash[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			hash[nums[i]]++;
		}
		for (int i = 0; i < n + 1; i++) {
			if (hash[i] == 0)
				return i;
		}

		return 0;
	}

	public int missingNumber_OptimalSolutionUsingSum(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return (((n * (n + 1)) / 2) - sum);
	}

	public int missingNumber_OptimalSolutionUsingXOR(int[] nums) {
		int n = nums.length;
		int xor1 = 0;
		for (int i = 1; i <= n; i++) {
			xor1 ^= i;
		}
		System.out.println("XOR1: "+xor1);
		int xor2 = 0;
		for (int i = 0; i < n; i++) {
			xor2 ^= nums[i];
		}
		System.out.println("XOR2: "+xor2);
		return xor1 ^ xor2;
	}

	// Using the concept that a ^ a = 0 and a ^ 0 = a
	// This will be better than the sum because sum can be stored into long if sum
	// is large
	// but xor will never exceed nums[i]
	public int missingNumber_OptimalSolutionUsingXOROptimized(int[] nums) {
		int n = nums.length;
		int xor1 = 0, xor2 = 0;
		for (int i = 0; i < n; i++) {
			xor1 ^= (i + 1);
			xor2 ^= nums[i];
		}
		return xor1 ^ xor2;
	}
	
	public static void main(String[] args) {
		int nums[] = {3,0,1};
		MissingNumber_268 m = new MissingNumber_268();
		System.out.println(m.missingNumber_OptimalSolutionUsingXOR(nums));
		System.out.println(m.missingNumber_OptimalSolutionUsingXOROptimized(nums));
	}
}
