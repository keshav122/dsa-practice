package com.contest.weekly.count_372;

public class Make_three_Strings_Equal {

	 public int findMinimumOperations(String s1, String s2, String s3) {
	        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
	        
	        int i = 0;
	        while(i < minLen) {
	        	char firstChar = s1.charAt(i);
	        	char secondChar = s2.charAt(i);
	        	char thirdChar = s3.charAt(i);
	        	if(firstChar == secondChar && secondChar == thirdChar) {
	        		 i++;
	        	}else {
	        		break;
	        	}
	        	
	        }
	        if(i == 0) {
	        	return -1;
	        }
	        
	        return ((s1.length() - i) + (s2.length() - i) + (s3.length() - i));
	      
	    }
	 
	 public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abb";
		String s3 = "ab";
		Make_three_Strings_Equal obj = new Make_three_Strings_Equal();
		System.out.println(obj.findMinimumOperations(s1, s2, s3));
		
	}
}
