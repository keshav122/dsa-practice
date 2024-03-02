package com.dsa.sorting_2_2;

//Logic : Choose any element in the array as the pivot element and then place the 
//numbers smaller to it on the left and the numbers larger than it on the right 
//After the first round the pivot element is placed at the right position 
//Apply it for the left and right subarray
public class QuickSort {

	public static void quickSort(int[] input, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int partitionIndex = getPartitionIndex(input, startIndex, endIndex);
			quickSort(input, startIndex, partitionIndex - 1);
			quickSort(input, partitionIndex + 1, endIndex);
		}

	}

	private static int getPartitionIndex(int[] input, int startIndex, int endIndex) {
		int pivotElement = input[startIndex];
		int i = startIndex;
		int j = endIndex;
		while (i < j) {

			while (input[i] <= pivotElement && i <= endIndex - 1) {
				i++;
			}
			while (input[j] > pivotElement && j >= startIndex + 1) {
				j--;
			}

			if (i < j) {
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
			}
		}
		int temp = input[j];
		input[j] = input[startIndex];
		input[startIndex] = temp;
		return j;
	}

	public static void main(String[] args) {
		int[] v = { 2, 13, 4, 1, 3, 6, 28 };
		quickSort(v, 0, v.length - 1);
		for (int i : v) {
			System.out.print(i + " ");
		}
	}
}
