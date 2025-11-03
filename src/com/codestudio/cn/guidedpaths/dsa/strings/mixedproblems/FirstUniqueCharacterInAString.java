/*Author: keshav122 */
package com.codestudio.cn.guidedpaths.dsa.strings.mixedproblems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

	public static char firstNonRepeating(String str) {
		Map<Character,Integer> countMap = new LinkedHashMap<>();
		Map<Character,Boolean> map = new LinkedHashMap<>();
		
		for(int i = 0; i< str.length();i++){
			char c = str.charAt(i);
			if(!countMap.containsKey(c)){
				countMap.put(c, 1);
				map.put(c, true);
			}else{
				map.put(c, false);
			}
		}
		
		for(Map.Entry<Character, Boolean> entry : map.entrySet()){
			if(entry.getValue()){
				return entry.getKey();
			}
		}
		return '#';
	}
}
