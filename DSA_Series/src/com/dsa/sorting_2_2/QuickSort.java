package com.dsa.sorting_2_2;

//Logic : Choose any element in the array as the pivot element and then place the 
//numbers smaller to it on the left and the numbers larger than it on the right 
//After the first round the pivot element is placed at the right position 
//Apply it for the left and right subarray
public class QuickSort {

	public static void quickSort(int[] input,int startIndex, int endIndex) {
		if(startIndex >= endIndex || startIndex < 0 || endIndex > input.length-1) {
			return;
		}
		
		int pivotElement = input[startIndex];
		int pivotPos = startIndex;
		int i = startIndex + 1;
		while(i <= endIndex) {
			if(input[i] < pivotElement) {
				int temp = input[i];
				int count = i-pivotPos;
				for(int j = i; count > 0; j--,count--) {
					input[j] = input[j-1];
				}
				input[pivotPos] = temp;
				pivotPos++;
			}
			i++;
		}
		
		quickSort(input,startIndex, pivotPos-1);
		quickSort(input,pivotPos +1 , endIndex);
	}
	
	public static void main(String[] args) {
		int[] v = {2, 13 ,4 ,1 ,3, 6 ,28};
		quickSort(v, 0, v.length-1);
		for(int i : v) {
			System.out.print(i+" ");
		}
	}
}
