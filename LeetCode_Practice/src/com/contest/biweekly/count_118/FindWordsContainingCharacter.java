package com.contest.biweekly.count_118;

import java.util.List;
import java.util.ArrayList;

public class FindWordsContainingCharacter {

	public List<Integer> findWordsContaining(String[] words, char x) {

		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < words.length;i++) {
			String str = words[i];
			for(int j = 0 ; j< str.length(); j++) {
				if(str.charAt(j) == x) {
					list.add(i);
					break;
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		String s[] = {"abc","bcd","aaaa","cbc"};
		char x = 'a';
		FindWordsContainingCharacter f = new FindWordsContainingCharacter();
		System.out.println(f.findWordsContaining(s, x).toString());
	}
}
