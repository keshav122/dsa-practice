package com.dsa.arrays_3_3_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

	public static List<Integer> majorityElement_BruteForce(int[] v) {
		int threshold = (v.length) / 3;
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : v) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() > threshold) {
				res.add(entry.getKey());
			}
		}
		return res;

	}

	public static List<Integer> majorityElement_Moorevotingalgo(int[] v) {
		int threshold = (v.length) / 3;
		List<Integer> res = new ArrayList<>();
		int candidate1 = v[0];
		int cnt1 = 0;
		int candidate2 = v[0];
		int cnt2 = 0;
		for (int num : v) {
			if (num == candidate1) {
				cnt1++;
			} else if (num == candidate2) {
				cnt2++;
			} else if (cnt1 == 0 && num != candidate2) {
				candidate1 = num;
				cnt1 = 1;
			} else if (cnt2 == 0 && num != candidate1) {
				candidate2 = num;
				cnt2 = 1;
			} else {
				cnt1--;
				cnt2--;
			}
		}

		cnt1 = cnt2 = 0;
		for (int i : v) {
			if (i == candidate1) {
				cnt1++;
			}
			if (i == candidate2) {
				cnt2++;
			}
		}
		if (cnt1 > threshold) {
			res.add(candidate1);
		}

		if (cnt2 > threshold && !res.contains(candidate2)) {
			res.add(candidate2);
		}
		return res;

	}

	public static void main(String[] args) {

		int v[] = {1,1,1,2,2,2};
		System.out.println(majorityElement_Moorevotingalgo(v).toString());
	}

}
