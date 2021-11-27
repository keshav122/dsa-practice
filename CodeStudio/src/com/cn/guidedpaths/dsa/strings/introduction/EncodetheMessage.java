package com.cn.guidedpaths.dsa.strings.introduction;


import java.util.LinkedHashMap;
import java.util.Optional;

public class EncodetheMessage {

	public static String encode(String message) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		String res = "";
		for(int i = 0; i < message.length();i++){
			char c = message.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}else{
				
				 //Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
				// char key = map.keySet().stream().findFirst().get();
				// int value = map.get(key);
				 Optional<Character> optional = map.keySet().stream().findFirst();

				 if (!optional.isPresent()) {
				     continue;
				 }

				 char key = optional.get();
				 int value = map.get(key);
				 res += key+value;
				 map.remove(key);
				 map.put(c, 1);
			}
		}
		return res;
	}
}
