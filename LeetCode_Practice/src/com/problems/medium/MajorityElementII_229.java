package com.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII_229 {

	public List<Integer> majorityElement_MapI(int[] nums) {
		int threshold = (int) Math.floor(nums.length / 3);
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);

			} else {
				map.put(num, 1);
			}
			if (map.get(num) > threshold) {
				if (!res.contains(num)) {
					res.add(num);
				}
			}
		}
		return res;
	}

	public List<Integer> majorityElement_MapII(int[] nums) {
		int threshold = (int) Math.floor(nums.length / 3);
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.merge(num, 1, Integer::sum);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > threshold && !res.contains(entry.getKey())) {
				res.add(entry.getKey());
			}
		}

		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);

			} else {
				map.put(num, 1);
			}

		}
		return res;
	}

	//Using the observation that since we are storing only elements which appear more than [n/3] times , there can be at max 2 elements in the
	//resultant array , because the frequency of that element must be (n/3 +1) therefore the other elements cannot be of n/3 freq.
	public List<Integer> majorityElementBoyerMooreVoting(int[] nums) {
		int threshold = (int) Math.floor(nums.length / 3);
		int candidate1 = nums[0];
		int count1 = 0;
		int candidate2 = nums[0];
		int count2 = 0;
		//To find the potential candidates
		for(int num : nums) {
			if(num == candidate1) {
				count1++;
			}else if(num == candidate2) {
				count2++;
			}else if(count1 == 0) {
				candidate1 = num;
				count1 = 1;
			}else if(count2 == 0) {
				candidate2 = num;
				count2 = 1;
			}else {
				count1--;
				count2--;
			}
			
		}
		//To check the count of potential candidates
		count1 = count2 = 0;
		for(int num : nums) {
			if(num == candidate1) {
				count1++;
			}
			if(num == candidate2) {
				count2++;
			}
		}
        List<Integer> res = new ArrayList<>();
        if(count1 > threshold) {
        	res.add(candidate1);
        }
        if(count2 > threshold) {
        	res.add(candidate2);
        }
	
        return res;

	
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2 };
		MajorityElementII_229 m = new MajorityElementII_229();
		List<Integer> ans = m.majorityElement_MapII(nums);
		for (Integer a : ans) {
			System.out.print(a + " ");
		}

	}
}
