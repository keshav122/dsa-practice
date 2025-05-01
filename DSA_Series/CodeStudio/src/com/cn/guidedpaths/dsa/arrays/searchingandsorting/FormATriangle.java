package com.cn.guidedpaths.dsa.arrays.searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;

public class FormATriangle {

	public static boolean possibleToMakeTriangle_bruteForce(ArrayList<Integer> arr){
		for(int i = 0; i< arr.size(); i++){
			for(int j = i+1 ; j< arr.size();j++){
				for(int k = j+1 ; k<arr.size();k++){
					boolean check1 = arr.get(i) + arr.get(j) > arr.get(k);
					boolean check2 = arr.get(i) + arr.get(k) > arr.get(j);
					boolean check3 = arr.get(j) + arr.get(k) > arr.get(i);
					if(check1 && check2 && check3){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean possibleToMakeTriangle(ArrayList<Integer> arr){
		Collections.sort(arr);
		for(int i = 0 ; i< arr.size()-2;i++){
			if(checkValidTriangle(arr.get(i), arr.get(i+1),arr.get(i+2))){
				return true;
			}
		}
		return false;
	}

	private static boolean checkValidTriangle(int a, int b , int c) {
		boolean check1 = a + b > c;
		boolean check2 = b + c > a;
		boolean check3 = a + c > b;
		if(check1 && check2 && check3){
			return true;
		}
		return false;
	}
	
	
}
