package com.dsa.arrays_3_2_medium;

public class TwoSum {

	public static String read(int n, int[] book, int target) {
        for(int i = 0; i< n ; i++) {
        	int val = target - book[i];
        	for(int j = i+1 ; j< n ; j++) {
        		if(book[j] == val) {
        			return "YES";
        		}
        	}
        }
        return "NO";
	}
	
	public static void main(String[] args) {
		int book[] = {4,1,2,3,1};
		int target = 5;
		System.out.println(read(book.length,book,target));
	}
}
