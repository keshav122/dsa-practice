package com.dsa.binary_search._4_2.answers;

public class RoseGarden {

	public static int roseGarden(int[] arr, int r, int b) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		for (int day = 1; day <= max; day++) {
			int bouquetCount = 0;
			int oneBouquetCount = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] <= day) {
					oneBouquetCount++;
				} else {
					oneBouquetCount = 0;
				}
				if (oneBouquetCount == r) {
					bouquetCount++;
					oneBouquetCount = 0;
				}

				if (bouquetCount == b) {
					return day;
				}
			}
		}
		return -1;
	}
	
	public static int roseGarden1(int[] arr, int r, int b) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int minDay = Integer.MAX_VALUE;
		int lowDay = 1;
		int highDay = max;
		while (lowDay <= highDay) {
			int midDay = (lowDay + highDay)/2;
			int bouquetCount = 0;
			int oneBouquetCount = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] <= midDay) {
					oneBouquetCount++;
				} else {
					oneBouquetCount = 0;
				}
				if (oneBouquetCount == r) {
					bouquetCount++;
					oneBouquetCount = 0;
				}

				if (bouquetCount == b) {
					minDay = Math.min(minDay, midDay);
					break;
				}
			}
			if(bouquetCount < b) {
				lowDay = midDay + 1;
			}else {
				highDay = midDay -1;
			}
		}
		return (minDay == Integer.MAX_VALUE) ? -1 : minDay;
	}
	
	
	public static void main(String[] args) {
		int[] rose = { 1, 2, 1, 2, 7, 2, 2, 3, 1};
		int r = 3;
		int b = 2;

		System.out.println(roseGarden1(rose, r, b));
	}
}
