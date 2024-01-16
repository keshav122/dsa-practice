package com.dsa.basic_1_4.basic_maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArmstrongNumber {

	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(is);
		try {
			int n = Integer.parseInt(bf.readLine());
			System.out.println(isArmstrongNumber(n));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean isArmstrongNumber(int n) {
		int temp = n;
		int digitCount = 0;
		while(n > 0) {
			digitCount++;
			n /= 10;
		}
		long sum = 0;
		n = temp;
		while(n > 0) {
			int lastDigit = n % 10;
			sum += Math.pow(lastDigit, digitCount);
			n /= 10;
		}
		return (sum == temp);
	}

}
