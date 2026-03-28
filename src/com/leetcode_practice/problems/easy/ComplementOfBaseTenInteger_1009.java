package com.leetcode_practice.problems.easy;

public class ComplementOfBaseTenInteger_1009 {

	 public int bitwiseComplement_BF(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder complement = new StringBuilder();
        for(int i = 0; i< s.length(); i++){
            char ch = (s.charAt(i) == '0') ? '1' : '0';
            complement.append(ch);
        }
        return Integer.parseInt(complement.toString(),2);
        
    }
	
	
	public int bitwiseComplement(int n) {
       return n == 0 ? 1 : ((Integer.highestOneBit(n) << 1) - 1) ^ n;
    }
}
