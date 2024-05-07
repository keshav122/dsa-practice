package com.dsa.binary_search._4_2.answers;

public class CapacityToShipPackagesWithinDDays {

	 public static int leastWeightCapacity(int[] weights, int d) {
		   int maxWt  = weights[0];
	       int sum = 0;
	       for(int weight : weights) {
	    	   sum += weight;
	    	   maxWt = Math.max(weight,maxWt);
	       }
	       
	       int minCap = Integer.MAX_VALUE;
	       int lowCap = maxWt;
	       int highCap = sum;
	       
	       while(lowCap <= highCap) {
	    	   int  midCap = (lowCap + highCap)/2;
	    	   int dayReq = days(weights, midCap);
	    	   if(dayReq <= d) {
	    		   minCap = Math.min(midCap, minCap);
	    		   highCap = midCap -1;  
	    	   }else {
	    		   lowCap = midCap + 1;
	    	   }  
	       }
	       return minCap;
	    }

	private static int days(int[] weights, int midCap) {
		int day = 1 , load = 0;
		for(int weight : weights) {
			//If the sum of load and weight is more than the capacity 
			//we will add the weight on the next day
			if(load + weight > midCap) {
				day++;
				load = weight;
			}else{
				load += weight;
			}
		}
		return day;
	}
	 
}
