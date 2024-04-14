package com.dsa.arrays_3_3_hard;

public class TeamContest {
	public static int team(int[] skill, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (skill[i] > 2 * skill[j]) {
					count++;
				}
			}
		}
		return count;
	}

	public static int team_Optimal(int[] skill, int n) {
		return mergeSort(skill, 0, n - 1);
	}

	private static int mergeSort(int[] skill, int low, int high) {
		int count = 0;
		if (low >= high)
			return count;
		int mid = (low + high) / 2;
		count += mergeSort(skill, low, mid);
		count += mergeSort(skill, mid + 1, high);
		count += countPairs(skill, low, mid, high);
		merge(skill, low, mid, high);
		return count;
	}

	private static int countPairs(int[] skill, int low, int mid, int high) {
		int count = 0;
        int right = mid+1;
        for(int left = low; left <= mid; left++){
           while(right <= high){
        	   long leftVal = skill[left];
               long rightVal = 2 * skill[right];
               if(leftVal > rightVal){
                  right++;
               }else{
                   break;
               }  
           }
           count += (right - (mid+1));
        }
        return count;
	}

	private static void merge(int[] skill, int low, int mid, int high) {
		int temp[] = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (skill[i] <= skill[j]) {
				temp[k] = skill[i];
				i++;
			} else {
				temp[k] = skill[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = skill[i];
			i++;
			k++;
		}

		while (j <= high) {
			temp[k] = skill[j];
			j++;
			k++;
		}
		
		for(i = low; i<= high ; i++) {
			skill[i] = temp[i-low];
		}
	}
}

