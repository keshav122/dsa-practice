package com.dsa.basic_1_4.basic_maths;

public class GCD_or_HCF {

	public static int calcGCD(int n, int m){
	    if(n%m == 0) {
	    	return m;
	    }
	    return calcGCD(m, n % m);
    }
	
	public static int calcGCD_Way1(int n, int m){
		while( n > 0 && m > 0) {
			if(n > m) n = n %m;
			else m = m % n;
		}
		return (n== 0) ? m : n;
	}
	
	
}
