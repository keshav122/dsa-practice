package com.dsa.sorting_2_2;

public class MergeSort {

	 public static void mergeSort(int[] arr, int l, int r){
		 if(l== r) {
			 return;
		 }
	      int mid = (l+r) /2;
	      mergeSort(arr, l, mid);
	      mergeSort(arr, mid+1, r);
	      mergeTwoSortedHalves(arr,mid,l,r);
	 }

	private static void mergeTwoSortedHalves(int[] arr, int mid, int l, int r) {
		int temp[] = new int[r-l+1];
		int i = l;
		int j = mid+1; 
		int k = 0;
		while(i <= mid && j <= r) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j<=r) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		
		for(i = l; i <= r;i++) {
			arr[i] = temp[i-l];
		} 
	}
	
	public static void main(String[] args) {
		int[] v = { 2 ,13, 4, 1, 3 ,6 ,28 };
	     mergeSort(v, 0,v.length-1);
		for (int i : v) {
			System.out.print(i + " ");
		}
	}
}
