package com.dsa.basic_1_5.basic_recursion;

public class IsPalindrome {

	public static boolean isPalindrome(String str) {
        return isPalindrome(str,0, str.length()-1);
    }
	
	public static boolean isPalindrome_OnePointer(String str) {
        return isPalindrome(str,0);
    }

	private static boolean isPalindrome(String str, int sI) {
		if(sI >= (str.length() /2)) {
			return true;
		}
		
		if(str.charAt(sI) != str.charAt(str.length()-sI-1)) {
			return false;
		}
		return isPalindrome(str, ++sI);
	}
	
	private static boolean isPalindrome(String str, int sI, int eI) {
		if(sI > eI) {
			return true;
		}
		if(str.charAt(sI) != str.charAt(eI)) {
			return false;
		}
		return isPalindrome(str, ++sI, --eI);
	}
	public static void main(String[] args) {
		String str = "abcba";
		System.out.println(isPalindrome(str));
	}
}
