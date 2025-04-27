/*Author: keshav122 */
package com.problems.easy;

import java.util.*;

public class SingleNumber_136 {

	public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
           if(map.containsKey(num)) {
        	   map.put(num, 2);
           }else {
        	   map.put(num, 1);
           }  
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if(entry.getValue() == 1) {
        		return entry.getKey();
        	}
        }
        return -1;
    }
	
	
	//XOR Based Solution
	public int singleNumber_XOR(int[] nums) {
       int val = nums[0];
       for(int i = 1;i < nums.length;i++) {
    	   val ^= nums[i];
       }
       return val;
    }
	
}
   }
	
}
