package com.dsa.basic_1_5.basic_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfFirstNNaturalNumbers {

	public static long sumFirstN(long n) {
		if(n == 1) {
			return n;
		}
		long smallAns = sumFirstN(n-1);
		return (n + smallAns);
	}
	
	
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		try {
			n = Integer.parseInt(bf.readLine());
			//Sum using Parameterized recursion
			long sum = sumOfNos(n,0);
			System.out.println(sum);
			System.out.println(sumFirstN(n));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

	//Sum using Parameterized recursion
	private static long sumOfNos(int i, int sum) {
		if(i < 1) {
			return sum;
		}
		return sumOfNos(i-1, sum + i);
	}
}
