package com.dsa.arrays_3_1_easy;

public class MoveZeroesToEnd {

	//Additional space is used
	public static int[] moveZeros(int n, int[] a) {
		int ans[] = new int[n];
		int i = 0;// to iterate on input array
		int j = 0;//to give index of res array
		while(i < n) {
			if(a[i] != 0) {
				ans[j] = a[i];
				j++;
			}
			i++;
		}
		return ans;
	}
	
	
	public static int[] moveZeros_Way1(int n, int[] a) {
		//First find the a zero
		int j = -1;
		for(int i = 0; i < n ; i++) {
			if(a[i] == 0) {
				j=i;
				break;
			}
		}
		//Iterate from the next value where you found the zero and if the value 
		//is a non -zero number swap the numbers
		if(j != -1) {
			for(int i = j +1 ; i < n ; i++) {
				if(a[i] != 0) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					j++;
				}
			}
		}
		return a;
	}
}
