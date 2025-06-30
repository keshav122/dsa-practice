package com.problems.easy;

import java.util.Arrays;

public class MinimumNumberofMovestoSeatEveryone_2037 {
	
	public int minMovesToSeat(int[] seats, int[] students) {
		Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        int moves = 0;
        for(int i = 0 ; i< n ; i++){
            if(seats[i] != students[i]){
                moves += Math.abs(seats[i] - students[i]);
            }
        }
        return moves;
	}
}
