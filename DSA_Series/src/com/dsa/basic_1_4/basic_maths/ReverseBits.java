package com.dsa.basic_1_4.basic_maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseBits {

	public static long reverseBits(long n) {
	  String result = String.format("%32s", Long.toBinaryString(n)).replace(' ', '0');
	  String reversedString = reverseString(result);
	  return Long.parseUnsignedLong(reversedString, 2);
	}

	private static String reverseString(String binaryString) {
	  String temp = "";
	  for(int i = binaryString.length() -1; i >= 0; i--) {
		  temp += binaryString.charAt(i);
	  }
	  return temp;
	}
	
	public static void main(String[] args) {
		
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(is);
			long n = Long.parseLong(bf.readLine());
			System.out.println(reverseBits(n));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
