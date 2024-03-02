package com.dsa.arrays_3_2_medium;

import java.util.LinkedList;
import java.util.List;

public class AlternateNumbers {

	public static int[] alternateNumbers(int[] a) {
		List<Integer> positiveInteger = new LinkedList<>();
		List<Integer> negativeInteger = new LinkedList<>();
		for (int val : a) {
			if (val > 0) {
				positiveInteger.add(val);
			} else {
				negativeInteger.add(val);
			}
		}
		int k = 0;
		for (int i = 0; i <= a.length - 2; i += 2) {
			a[i] = positiveInteger.get(k);
			a[i + 1] = negativeInteger.get(k);
			k++;
		}
		return a;
	}

	public static int[] alternateNumbers_Way1(int[] a) {
		int n = a.length;
		int posCounter = 0;
		int negCounter = n / 2;
		int temp[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				temp[posCounter] = a[i];
				posCounter++;
			} else {
				temp[negCounter] = a[i];
				negCounter++;
			}
		}

		posCounter = 0;
		negCounter = n / 2;
		for (int i = 0; i <= a.length - 2; i += 2) {
			a[i] = temp[posCounter];
			a[i + 1] = temp[negCounter];
			posCounter++;
			negCounter++;
		}
		return a;
	}

	public static int[] alternateNumbers_Way2(int[] a) {
		int n = a.length;
		int ans[] = new int[n];
		int posCounter = 0,negCounter = 1;
		for(int i = 0 ; i< n ; i++) {
			if(a[i] > 0) {
				ans[posCounter] = a[i] ;
				posCounter+= 2;
			}else {
				ans[negCounter] = a[i] ;
				negCounter+= 2;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int arr[] = { 1, 2, -3, -1, -2, 3 };
		int a[] = alternateNumbers(arr);
		for (int i : a) {
			System.out.print(i + " ");
		}

	}
}
