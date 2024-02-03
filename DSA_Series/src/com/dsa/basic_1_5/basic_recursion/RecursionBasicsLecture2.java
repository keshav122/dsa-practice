package com.dsa.basic_1_5.basic_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionBasicsLecture2 {

	
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		try {
			n = Integer.parseInt(bf.readLine());
			printNames(1,n);//change of parameters
			System.out.println();
			System.out.println("1 to N :");
			print1toN(1,n);
			System.out.println();
			System.out.println("N to 1 :");
			printNto1(n,n);
			System.out.println();
			System.out.println("1 to N using backtrack:");
			print1toN_Backtrack(n,n);
			System.out.println();
			System.out.println("N to 1 using backtrack:");
			printNto1_Backtrack(1,n);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void printNto1_Backtrack(int i, int n) {
		if(i > n) return;
		printNto1_Backtrack(i+1, n);
		System.out.print(i+" ");
		
	}

	private static void print1toN_Backtrack(int i, int n) {
		if(i < 1) return;
		print1toN_Backtrack(i-1, n);
		System.out.print(i+" ");
	}

	private static void printNames(int i, int n) {
		if(i > n) return;
		System.out.print("Coder"+" ");
		printNames(i+1, n);
	}
	
	private static void print1toN(int i, int n) {
		if(i > n) return;
		System.out.print(i+" ");
		print1toN(i+1, n);
	}

	private static void printNto1(int i, int n) {
		if(i < 1) return;
		System.out.print(i+" ");
		printNto1(i-1, n);
	}

}
