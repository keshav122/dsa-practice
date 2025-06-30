package com.leetcode-practice.problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncreasingFrequency_1636 {

	public int[] frequencySort(int[] nums) { 
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums) {
        	freqMap.merge(num, 1, Integer::sum);
        }
        List<Pair> li = new ArrayList<>();
        for(Integer x : freqMap.keySet()) {
        	li.add(new Pair(x,freqMap.get(x)));
        }
        Collections.sort(li,(a,b) -> {
        	if(a.freq == b.freq) {
        		return b.num - a.num;
        	}else {
        		return a.freq - b.freq;
        	}
        });
        int k = 0; 
        int i = 0;
        while(k < nums.length) {
        	for(int count = 0; count < freqMap.get(li.get(i).num); count++) {
        		nums[k] = li.get(i).num;
        		k++;
        	}
        	i++;
        }
        return nums;
	}
}

class Pair{
	int num;
	int freq;
	
	public Pair(int num, int freq) {
		super();
		this.num = num;
		this.freq = freq;
	}
	
}