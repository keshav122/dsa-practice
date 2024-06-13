package com.dsa.strings.easy;

public class LargestOddNumberInString {

	public String largestOddNumber(String num) {
        int i = num.length() -1;
        while(i >= 0){
            int currDigit = Integer.parseInt(num.substring(i,i+1));
            if(currDigit % 2 == 1) {
                return num.substring(0,i+1);
            }
            i--;
        }
        return "";
    }
	
	public String largestOddNumber_Way1(String num) {
        int i = num.length() -1;
        while(i >= 0){
        	char c = num.charAt(i);
        	boolean isOdd = (c == '1' || c=='3' || c == '5' || c=='7' || c=='9');
            if(isOdd) {
                return num.substring(0,i+1);
            }
            i--;
        }
        return "";
    }
}
