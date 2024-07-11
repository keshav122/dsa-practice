package com.dsa.binary_search._4_3.twoDArray;

import java.util.ArrayList;
import java.util.Collections;

public class MedianInaRowWiseSortedMatrix {

	int median(int matrix[][], int R, int C) {
        ArrayList<Integer> li = new ArrayList<>();
        for(int i = 0; i< R ; i++) {
        	for(int j = 0 ; j < C; j++) {
        		li.add(matrix[i][j]);
        	}
        }
        Collections.sort(li);
        return li.get((R*C)/2);
    }
	
	int median_better(int matrix[][], int R, int C) {
		int low = matrix[0][0];
		int high = matrix[0][C-1];
		for(int i = 1; i< R ; i++) {
			low = Math.min(low, matrix[i][0]);
			high = Math.max(high, matrix[i][C-1]);
		}
		int req = (R * C)/2;
		while(low <= high) {
			int mid = (low + high)/2;
			int smallerThanVal = smallerVal(matrix, mid,R,C);
			if(smallerThanVal <= req) {
				low = mid + 1;
			}else {
				high = mid-1;
			}
		}
		return low;
		
	}

	private int smallerVal(int[][] matrix, int mid, int R,int C) {
		int count = 0;
		for(int i = 0; i< R; i++) {
			count += upper_bound(matrix[i],mid,C);
		}
		return count;
	}

	private int upper_bound(int[] a, int x, int m) {
		int low = 0;
		int high = m-1;
		int ans = m;//if no element is greater
		while(low <= high) {
			int mid = (low + high)/2;
			if(a[mid] <= x) {
				low = mid +1;
			}else {
				ans = mid;
				high = mid-1;
			}
		}
		return ans;
	}
	
	
	public static int getMedianArrayList(ArrayList<ArrayList<Integer>> matrix)
	{
		int R = matrix.size();
		int C = matrix.get(0).size();
		int low = matrix.get(0).get(0);
		int high = matrix.get(0).get(C-1);
		for(int i = 1; i< R ; i++) {
			low = Math.min(low, matrix.get(i).get(0));
			high = Math.max(high, matrix.get(i).get(C-1));
		}
		
		int req = (R * C)/2;
		while(low <= high) {
			int mid = (low + high)/2;
			int smallerThanVal = smallerValList(matrix, mid,R,C);
			if(smallerThanVal <= req) {
				low = mid + 1;
			}else {
				high = mid-1;
			}
		}
		return low;
	}
	
	private static int smallerValList(ArrayList<ArrayList<Integer>> matrix, int mid, int R,int C) {
		int count = 0;
		for(int i = 0; i< R; i++) {
			count += upper_bound(matrix.get(i),mid,C);
		}
		return count;
	}
	
	private static int upper_bound(ArrayList<Integer> a, int x, int m) {
		int low = 0;
		int high = m-1;
		int ans = m;//if no element is greater
		while(low <= high) {
			int mid = (low + high)/2;
			if(a.get(mid) <= x) {
				low = mid +1;
			}else {
				ans = mid;
				high = mid-1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[][] m = {{1 ,3, 5 }, {2 ,6, 9}, {3, 6, 9}};
		int r = 3;
		int c = 3;
		MedianInaRowWiseSortedMatrix obj = new MedianInaRowWiseSortedMatrix();
		System.out.println(obj.median_better(m, r, c));
	}
}
