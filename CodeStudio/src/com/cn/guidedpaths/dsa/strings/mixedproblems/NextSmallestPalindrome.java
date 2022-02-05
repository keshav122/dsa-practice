package com.cn.guidedpaths.dsa.strings.mixedproblems;

public class NextSmallestPalindrome{
	public static String nextLargestPalindrome(String number, int length) {
		int num = Integer.parseInt(number);
		int i = num + 1;
		
		while(i< 100000){
			String st = Integer.toString(i);
			if(isPalindrome(st)){
				return st;
			}
			i++;
		}
		return number;
	}

	private static boolean isPalindrome(String st) {
		int i = 0, j= st.length()-1;
		while(i <=j){
			if(st.charAt(i) != st.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
