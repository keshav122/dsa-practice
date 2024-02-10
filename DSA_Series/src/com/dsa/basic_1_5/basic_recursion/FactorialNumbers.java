package com.dsa.basic_1_5.basic_recursion;

import java.util.ArrayList;
import java.util.List;

public class FactorialNumbers {

	public static List<Long> factorialNumbers(long n) {
        List<Long> li = new ArrayList<>();
        factorialNumbers(li,n , 1,1);
        return li;
    }

	private static void factorialNumbers(List<Long> li, long n, long i, long currNum) {
		if(currNum > n) {
            return;			
		}
		li.add(Long.valueOf(currNum));
		i++;
		currNum *= i;
		
		factorialNumbers(li, n, i,currNum);
	}
	
	public static void main(String[] args) {
		List<Long> ans = factorialNumbers(101466824);
		for(long i : ans) {
			System.out.print(i+" ");
		}
	}
}
