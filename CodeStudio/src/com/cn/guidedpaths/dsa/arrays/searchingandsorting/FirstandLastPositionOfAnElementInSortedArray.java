package com.cn.guidedpaths.dsa.arrays.searchingandsorting;

import java.util.ArrayList;

public class FirstandLastPositionOfAnElementInSortedArray {
	
	public static Pair findFirstLastPosition_BruteForce(ArrayList<Integer> arr, int n, int x) {
		boolean isFirstCharacterYetToBeFound = true;
		Pair ans = new Pair();
        ans.first = -1;
        ans.second = -1;
		for(int i = 0; i<arr.size()-1;i++){
			if(arr.get(i) == x && isFirstCharacterYetToBeFound)  {
				ans.first = i;
				isFirstCharacterYetToBeFound = false;
			}
			if(arr.get(i) == x && arr.get(i+ 1) != x && !isFirstCharacterYetToBeFound)  {
				ans.second = i;
                break;
			}
			
		}
        if(arr.get(arr.size() -1) == x){
          if(isFirstCharacterYetToBeFound){
            ans.first = arr.size() -1;
          }
             ans.second = arr.size() -1;
        }
		return ans;
	}
	
	public static Pair findFirstLastPosition(ArrayList<Integer> arr, int n, int x) {
		int sI = 0;
		int eI = n - 1;
		Pair p = new Pair();
		p.first = -1;
		p.second = -1;
		while (sI <= eI) {
			int mid = sI + (eI - sI) / 2;
			if (arr.get(mid) == x) {
				p.first =mid;
				return getRange(arr, mid, x ,p);
			} else if (arr.get(mid) > x) {
				eI = mid - 1;
			} else {
				sI = mid + 1;
			}
		}
		
		return p;
	}

	private static Pair getRange(ArrayList<Integer> arr, int mid, int x, Pair p) {
		 boolean initialIndexFound = false;
	        boolean lastIndexFound = false;
			for(int i = mid ; i>= 0;i--){
				if(arr.get(i) != x){
					p.first = i+1;
	                initialIndexFound = true;
					break;
				}
			}
	        if(!initialIndexFound){
	            p.first = 0;
	        }
	        
			for(int j = mid ; j< arr.size();j++){
				if(arr.get(j) != x){
					p.second = j-1;
	                lastIndexFound = true;
					break;
				}
			}
	        if(!lastIndexFound){
	         p.second = arr.size() -1;
	        }
			return p;
	}

}

class Pair {
	int first;
	int second;

}