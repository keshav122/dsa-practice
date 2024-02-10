package com.dsa.basic_1_4.basic_maths;

public class CountDigits {

	public static int countDigits(int n) {
		int temp = n;
		int count = 0;

		while (n > 0) {
			int lastDigit = n % 10;
			if (lastDigit != 0 && temp % lastDigit == 0) {
				count++;
			}
			n /= 10;
		}
		return count;
	}
	
	public static int countDigits_1(int n){
		int count = 0;
		while (n > 0) {
			count++;
			n /= 10;
		}
		return count;
    }
	
	//Faster way
	public static int countDigits_2(int n){
		return (int) (Math.log10(n) + 1);
    }
}
