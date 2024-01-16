package com.dsa.basic_1_4.basic_maths;

public class GCD_or_HCF {

	public static int calcGCD(int n, int m){
	    if(n%m == 0) {
	    	return m;
	    }
	    return calcGCD(m, n % m);
    }
}
