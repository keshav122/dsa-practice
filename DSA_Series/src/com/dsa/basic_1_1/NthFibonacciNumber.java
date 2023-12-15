package com.dsa.basic_1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthFibonacciNumber {
	
	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(is);
			int input = Integer.parseInt(bf.readLine());
			if (input <= 2) {
				System.out.println(1);
				return;
			}
			int ans[] = new int[input];
			ans[0] = ans[1] = 1;
			for (int i = 2; i < ans.length; i++) {
				ans[i] = ans[i - 1] + ans[i - 2];
			}
			System.out.println(ans[input - 1]);
		} catch (IOException io) {
			System.out.println("I/O Exception Occured");
		}

	}

}
