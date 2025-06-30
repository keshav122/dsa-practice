package com.codestudio.cn.guidedpaths.dsa.strings.introduction;

import java.util.Stack;

public class EncodetheMessage {
	//4504 ms
	public static String encode(String message) {
		StringBuilder result=new StringBuilder();
		Stack<Character> st = new Stack<>();
	    int i = 0;
		while(i < message.length()){
			char c = message.charAt(i);
			if(st.isEmpty()){
				st.push(c);
				i++;
			}else{
				if(c != st.peek()){
					result.append(st.peek());
					result.append(st.size());
					//res += st.peek()+Integer.toString(st.size());
					while(!st.isEmpty()){
						st.pop();
					}
					st.push(c);
					i++;
				}else{
					st.push(c);
					i++;
				}
			}
		}
		if(!st.isEmpty()){
			result.append(st.peek());
			result.append(st.size());
			//res +=  st.peek()+Integer.toString(st.size());
		}
		return result.toString();
	}
	
	//Optimal Sol - 1784 ms
	public static String encode_1(String message) {
		StringBuilder result=new StringBuilder();
		char currentCharacter = message.charAt(0);
		int count = 1;
	    int i = 1;
		while(i < message.length()){
			char c = message.charAt(i);
			if(c != currentCharacter){
				result.append(currentCharacter);
				result.append(count);
				currentCharacter = c;
				count = 1;
				i++;
			}else{
				count++;
				i++;
			}
		}
		
		result.append(currentCharacter) ;
		result.append(count);
		return result.toString();
	}
	
	public static String encode_2(String message) {
	 int n = message.length();
	 String res = "";
     int count = 1;
       for (int i = 1; i < n; i++) {

           // Count occurrences of current character
            
           if(message.charAt(i) == message.charAt(i-1)){
             count++;
           }
         else{
           res += message.charAt(i) + count;
           count = 1;
         }
       }
       
       // Print character and its count
       res += message.charAt(message.length()-1) + count;
       return res;
}
}
