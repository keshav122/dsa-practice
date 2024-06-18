package com.dsa.binary_search._4_3.twoDArray;

import java.util.ArrayList;
import java.util.List;

public class RowWithMaximum1s {

	public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
		int i = 0;
		int maxCount = 0; 
		int maxIndex = 0;
		while(i < n) {
			ArrayList<Integer> arr = mat.get(i);
			int count = 0;
			for(int j = 0; j < m; j++) {
				if(arr.get(j) == 1) count++;
			}
			if(count > maxCount) {
				maxCount = count;
				maxIndex = i;
			}
			i++;
		}
		return maxIndex;
    }
	
	
	public static int rowMaxOnes_1(ArrayList<ArrayList<Integer>> mat, int n, int m) {
		    int i = 0; 
			int minIndex = Integer.MAX_VALUE;
			int maxRow = -1;
			while(i < n) {
				ArrayList<Integer> arr = mat.get(i);
				int index = getOriginIndex(arr,m);
				if(index > -1 && index < minIndex) {
					minIndex = Math.min(minIndex, index);
					maxRow  = i;
				}
				i++;
			}
			return maxRow;
	}
	
	
	private static int getOriginIndex(ArrayList<Integer> arr, int m) {
		int low = 0;
		int high = m-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr.get(mid) == 1) {
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}
		if(low == m) return -1;
		else return low;
	}


	 int rowWithMax1s(int arr[][], int n, int m) {
	        int i = 0; 
				int minIndex = Integer.MAX_VALUE;
				int maxRow = -1;
				while(i < n) {
					int a[] = arr[i];
					int index = getOriginIndex(a,m);
					if(index > -1 && index < minIndex) {
						minIndex = Math.min(minIndex, index);
						maxRow  = i;
					}
					i++;
				}
				return maxRow;
	    }
	    
	    private static int getOriginIndex(int[] arr, int m) {
			int low = 0;
			int high = m-1;
			while(low <= high) {
				int mid = (low + high)/2;
				if(arr[mid] == 1) {
					high = mid-1;
				}else {
					low = mid + 1;
				}
			}
			if(low == m) return -1;
			else return low;
		}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		List<Integer> liA = List.of(1, 1, 1);
		ArrayList<Integer> li1 = new ArrayList<>();
		li1.addAll(liA);
		List<Integer> liB = List.of(0, 0, 1);
		ArrayList<Integer> li2 = new ArrayList<>();
		li2.addAll(liB);
		List<Integer> liC = List.of(0, 0, 0);
		ArrayList<Integer> li3 = new ArrayList<>();
		li3.addAll(liC);
		arr.add(li1);
		arr.add(li2);
		arr.add(li3);
		System.out.println(rowMaxOnes(arr,3,3));
 	}
}
