package com.dsa.strings.medium;

public class ReverseWordsInAString {

	 public String reverseWords(String s) {
	        boolean isCharEncountered = false;
	        int i = s.length()-1;
	        StringBuilder sb = new StringBuilder();
	        int lastPos = s.length()-1;
	        while(i >= 0){
	            if(s.charAt(i) != ' ' && !isCharEncountered){
	                lastPos = i+1;
	                isCharEncountered = true;
	            } else  if(s.charAt(i) == ' ' && isCharEncountered){
	                sb.append(s.substring(i+1,lastPos));
	                sb.append(" ");
	                 isCharEncountered = false;
	            }
	           
	            i--;
	        }
	        if(isCharEncountered){
	            sb.append(s.substring(0,lastPos));
	        }
	        return sb.toString().trim();
	    }
}
