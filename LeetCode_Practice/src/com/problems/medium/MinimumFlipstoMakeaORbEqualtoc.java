package com.problems.medium;

public class MinimumFlipstoMakeaORbEqualtoc {

	public int minFlips(int a, int b, int c) {
		if ((a | b) == c) {
			return 0;
		} else {
			int count = 0;
			String aInBit = Integer.toBinaryString(a);
			String bInBit = Integer.toBinaryString(b);
			String cInBit = Integer.toBinaryString(c);
			for (int i = 0; i < aInBit.length(); i++) {

			}
		}

	}

	public static void main(String[] args) {

	}

}
