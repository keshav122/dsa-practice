package com.dsa.strings.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

	public String frequencySortBruteForce(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freqMap.merge(c, 1, Integer::sum);
		}
		List<CharIntPair> li = new ArrayList<>();
		for (char c : freqMap.keySet()) {
			li.add(new CharIntPair(c, freqMap.get(c)));
		}
		Collections.sort(li, (a, b) -> {
			return b.freq - a.freq;
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < li.size(); i++) {
			int count = freqMap.get(li.get(i).character);
			char charAppend = li.get(i).character;
			for (int j = 0; j < count; j++) {
				sb.append(charAppend);
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String test = "tree";
		SortCharactersByFrequency obj = new SortCharactersByFrequency();
		System.out.println(obj.frequencySortBruteForce(test));
	}
}

class CharIntPair {

	char character;
	int freq;

	public CharIntPair(char c, int freq) {
		super();
		this.character = c;
		this.freq = freq;
	}

}
