package com.contest;

import java.util.ArrayList;
import java.util.List;

public class Test_03_1 {

    public int[] resultArray(int[] nums) {
    	
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        firstList.add(nums[0]);
        secondList.add(nums[1]);
        int lastPointerFirstList = 0;
        int lastPointerSecondList = 0;
        for(int i = 2 ; i< nums.length ; i++) {
        	if(firstList.get(lastPointerFirstList) > secondList.get(lastPointerSecondList)) {
        		firstList.add(nums[i]);
        		lastPointerFirstList++;
        	}else {
        		secondList.add(nums[i]);
        		lastPointerSecondList++;
        	}
        }
        
       int i = 0;
       int j = 0;
       while(j < firstList.size()) {
    	   nums[i] = firstList.get(j);
    	   i++;
    	   j++;
       }
       
       j = 0;
       while(j < secondList.size()) {
    	   nums[i] = secondList.get(j);
    	   i++;
    	   j++;
       }
       
       return nums;
    }
}
