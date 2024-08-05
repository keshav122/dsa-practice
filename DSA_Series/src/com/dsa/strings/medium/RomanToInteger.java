package com.dsa.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

public int romanToInt(String s) {
        Map<Character,Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V',5);
        charMap.put('X',10);
        charMap.put('L',50);
        charMap.put('C',100);
        charMap.put('D',500);
        charMap.put('M',1000);
        int value = 0;
        int i = 0;
        while(i < s.length()-1) {
        	int c1 = charMap.get(s.charAt(i));
        	int c2 = charMap.get(s.charAt(i+1));		
        	if(c1 < c2) {
        		value += c2-c1;
        		i+=2;
        	}else {
        		value += c1;
        		i++;
        	}
        }
        if(i == s.length()-1) {
        	value += charMap.get(s.charAt(i));
        }
        return value;		
    }
}
