package com.dsa.basic_1_4.basic_maths;

import java.io.InputStreamReader;
import java.io.BufferedReader;
public class ReverseOfANumber {

	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(bf.readLine());
			reverseofNumber(n);
		}catch(Exception e) {
			
		}

	}

	private static void reverseofNumber(int n) {
		if(n == 0){
			System.out.println(n);
			return;
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 10);
			n /= 10;
		}
		int reversedInt = Integer.parseInt(sb.toString());
		System.out.println(reversedInt);
		
	}
	
	private static void reverseofNumber_betterApproach(int n) {
		int revNumber = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			n /= 10;
			revNumber = (revNumber * 10) + lastDigit;
		}
		
		System.out.println(revNumber);
		
	}
}
