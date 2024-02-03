package com.dsa.basic_1_4.basic_maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeNumber {

	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(is);
		try {
			int n = Integer.parseInt(bf.readLine());
			System.out.println(isPalindrome(n));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	private static boolean isPalindrome(int n) {
		String str = Integer.toString(n);
		int start = 0;
		int end = str.length() -1;
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end)) {
				 return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	private static boolean isPalindrome_1(int n) {
		int temp = n;
		int revNumber = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			n /= 10;
			revNumber = (revNumber * 10) + lastDigit;
		}
		return temp == revNumber;
	}
	
}
