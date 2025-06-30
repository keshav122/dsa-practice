package com.leetcode-practice.problems.medium;

public class MinimumNoOfDaysToMakeMBouquets_1482 {

	public int minDays(int[] bloomDay, int m, int k) {
		 int max = bloomDay[0];
		 for(int i = 1; i< bloomDay.length; i++) {
			 max = Math.max(max, bloomDay[i]);
		 }

		 for(int day = 1; day <= max ; day++) {
			 int bouquetCount = 0;
			 int oneBouquetCount = 0;
			 for(int i = 0; i< bloomDay.length; i++) {
				 if(bloomDay[i] <= day) {
					 oneBouquetCount++;
				 }else {
					 oneBouquetCount = 0;
				 }
				 if(oneBouquetCount == k) {
					 bouquetCount++;
					 oneBouquetCount = 0;
				 }
				 
				 if(bouquetCount == m) {
					 return day;
				 }
			 }
		 }
		 return -1;
	}
	
	public int minDays1(int[] bloomDay, int m, int k) {
		int max = bloomDay[0];
		for (int i = 1; i < bloomDay.length; i++) {
			max = Math.max(max, bloomDay[i]);
		}
		int minDay = Integer.MAX_VALUE;
		int lowDay = 1;
		int highDay = max;
		while (lowDay <= highDay) {
			int midDay = (lowDay + highDay)/2;
			int bouquetCount = 0;
			int oneBouquetCount = 0;
			for (int i = 0; i < bloomDay.length; i++) {
				if (bloomDay[i] <= midDay) {
					oneBouquetCount++;
				} else {
					oneBouquetCount = 0;
				}
				if (oneBouquetCount == k) {
					bouquetCount++;
					oneBouquetCount = 0;
				}

				if (bouquetCount == m) {
					minDay = Math.min(minDay, midDay);
					break;
				}
			}
			if(bouquetCount < m) {
				lowDay = midDay + 1;
			}else {
				highDay = midDay -1;
			}
		}
		return (minDay == Integer.MAX_VALUE) ? -1 : minDay;
	}
}
