package com.leetcode-practice.problems.medium;

import java.util.Arrays;

public class BoatsToSavePeople_881 {

	public int numRescueBoats(int[] people, int limit) {
		int minBoats = 0;
		Arrays.sort(people);
		int n = people.length;
		int i = n-1;
		while(people[i] >= limit) {
			i--;
		}
		minBoats += (n-i-1);
		int sI = 0;
		int eI = i;
		while(sI <= eI) {
			if(people[sI]+ people[eI] <= limit) {
				sI++;
				eI--;
			    minBoats++;
			}else {
				minBoats++;
				eI--;
			}
		}
		return minBoats;
	}

	public static void main(String[] args) {
		int[] people = {1,2};
		int limit = 3;
		BoatsToSavePeople_881 b = new BoatsToSavePeople_881();
		System.out.println(b.numRescueBoats(people, limit));
	}
}
