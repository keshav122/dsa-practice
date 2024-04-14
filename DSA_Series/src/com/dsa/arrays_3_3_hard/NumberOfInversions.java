package com.dsa.arrays_3_3_hard;

public class NumberOfInversions {

	public static int numberOfInversions(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					count++;
				}
			}
		}
		return count;
	}

	public static int numberOfInversions_Optimal(int []a, int n) {
		return mergeSort(a, 0, n-1);
    }

	public static int mergeSort(int a[], int low, int high) {
		int count = 0;
		if (low >= high)
			return count;
		int mid = (low + high) / 2;
		count += mergeSort(a, low, mid);
		count += mergeSort(a, mid + 1, high);
		count += merge(a, low, mid, high);
		return count;
	}

	private static int merge(int[] a, int low, int mid, int high) {
		int count = 0;
		int temp[] = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (a[i] <= a[j]) {
				temp[k] = a[i];
				i++;
			} 
			//right is smaller
			else {
				temp[k] = a[j];
				count += (mid -i + 1);
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = a[i];
			i++;
			k++;
		}

		while (j <= high) {
			temp[k] = a[j];
			j++;
			k++;
		}
		
		for(i = low ; i<=high;i++) {
			a[i] = temp[i-low];
		}
        return count;
	}
	
	public static void main(String[] args) {
		int a[] = {1 ,20,6, 4, 5};
		System.out.println(numberOfInversions_Optimal(a, a.length));
	}
}
