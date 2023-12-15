package com.dsa.basic_1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find_Character_Case {

	public static void main(String[] args) {
		try {

			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(is);
			char s = bf.readLine().charAt(0);
			if ((s - 'a') >= 0 && (s - 'a') < 26) {
				System.out.println("0");
			} else if ((s - 'A') >= 0 && (s - 'A') < 26) {
				System.out.println("1");
			} else {
				System.out.println("-1");
			}
		} catch (IOException io) {
			System.out.println("No input present");
		}

	}
}
