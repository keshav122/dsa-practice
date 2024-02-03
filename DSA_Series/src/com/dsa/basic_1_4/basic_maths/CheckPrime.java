package com.dsa.basic_1_4.basic_maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPrime {

	 public static void main(String[] args) {
		 InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(is);
			try {
				int n = Integer.parseInt(bf.readLine());
				System.out.println(isPrime(n));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	    }

	 public static boolean isPrime(int num) {
			if(num == 1) {
				return false;
			}
			for(int i = 2; i * i <= num ; i++) {
				if(num % i == 0) {
					return false;
				}
			} 
			return true;
		}
	 
}
