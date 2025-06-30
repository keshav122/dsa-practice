package com.cn.guidedpaths.dsa.strings.introduction;

import java.util.HashMap;
import java.util.Map;

public class RemoveVowels {

	public static String removeVowels(String str) {
		String res = "";
		 if(str == null || str.length() == 0){
	         return str;
	        }
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 1);
		map.put('e', 1);
		map.put('i', 1);
		map.put('o', 1);
		map.put('u', 1);
		map.put('A', 1);
		map.put('E', 1);
		map.put('I', 1);
		map.put('O', 1);
		map.put('U', 1);
		for(int i = 0; i < str.length();i++){
			char c = str.charAt(i);
			if(!map.containsKey(c)){
				res += c;
			}
		}
		return res;
	}
}
