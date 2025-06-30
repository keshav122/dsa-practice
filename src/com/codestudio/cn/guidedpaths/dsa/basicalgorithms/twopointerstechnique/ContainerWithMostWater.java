package com.codestudio.cn.guidedpaths.dsa.basicalgorithms.twopointerstechnique;

public class ContainerWithMostWater {

	public static int maxAreaBruteForce(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int tempArea = (j - i) * Math.min(height[i], height[j]);
				if (tempArea > maxArea) {
					maxArea = tempArea;
				}
			}
		}
		return maxArea;
	}
	
	//We calculate the area between the extreme endpoints and then 
	//check if there is any window in between which has larger area
	public static int maxAreaOptimized(int[] height) {
		int n = height.length;
		int maxArea = 0;
		int i = 0, j = n-1;
		
		while(i < j) {
			maxArea = Math.max(maxArea,(j-i) * (Math.min(height[i],height[j])));
			if(height[i] < height[j]){
				i++;
			}else{
				j--;
			}
			
		}
		return maxArea;
	}
}
