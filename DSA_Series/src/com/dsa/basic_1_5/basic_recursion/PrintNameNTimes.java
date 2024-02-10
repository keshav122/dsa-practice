package com.dsa.basic_1_5.basic_recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNameNTimes {

	public static void printNTime(String name , int n){
		if(n == 0) {
			return;
		}
		System.out.println(name);
		printNTime(name, n-1);
		
	}
	
	public static void main(String[] args) {
		String name = "Coder_003";
		int n = 5;
		printNTime(name, n);
	}
	
	
	public static List<String> printNtimes(int n){
        List<String> li = new ArrayList<>();
        printNtimes(li,n);
        return li;
    }

	private static void printNtimes(List<String> li, int n) {
		if(n == 0) {
			return ;
		}
		li.add("Coding Ninjas ");
		printNtimes(li, n-1);
	}
}

