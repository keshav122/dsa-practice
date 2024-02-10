package com.dsa.arrays_3_1_easy;

public class FindTheSingleElement {

	public static int getSingleElement(int []arr){
        for(int i = 0; i < arr.length-1; i+=2){
            if(arr[i] != arr[i+1]){
                return arr[i];
            }
        }
        return arr[arr.length-1] ;
    }
}
