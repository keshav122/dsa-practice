package com.dsa.basic_1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenProblem {

	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(is);
			int n = Integer.parseInt(bf.readLine());
			int evenSum = 0;
			int oddSum = 0;
			while (n > 0) {
				int lastDigit = n % 10;
				if (lastDigit % 2 == 0) {
					evenSum += lastDigit;
				} else {
					oddSum += lastDigit;
				}
				n = n / 10;
			}

			System.out.println(evenSum + " " + oddSum);
		} catch (IOException e) {

		}

	}
}
