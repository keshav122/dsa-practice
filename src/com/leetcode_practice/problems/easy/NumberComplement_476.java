package com.leetcode_practice.problems.easy;

public class NumberComplement_476 {

	 public int findComplement_BF(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder complement = new StringBuilder();
        for(int i = 0; i< s.length(); i++){
            char ch = (s.charAt(i) == '0') ? '1' : '0';
            complement.append(ch);
        }
        return Integer.parseInt(complement.toString(),2);
    }
	
	//hint : the addition of number and its complement will result in 111...11. N= 0 is a corner case
	 public int findComplement(int num) {
       return num == 0 ? 1 : ((Integer.highestOneBit(num) << 1) - 1) ^ num;
    }
}
