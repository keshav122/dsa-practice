package com.problems.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray_2053 {

	public String kthDistinct(String[] arr, int k) {
		Map<String, Integer> freqMap = new LinkedHashMap<>();
		for (String s : arr) {
			freqMap.merge(s, 1, Integer::sum);
		}
		int count = 0;
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() == 1) {
				count++;
			}
			if (count == k)
				return entry.getKey();
		}
		return "";
	}

	
}
