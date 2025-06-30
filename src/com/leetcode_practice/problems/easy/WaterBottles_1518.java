package com.leetcode_practice.problems.easy;

public class WaterBottles_1518 {

	public int numWaterBottles(int numBottles, int numExchange) {

		int count = numBottles;
		int empyWaterBottles = numBottles;
		while(empyWaterBottles >= numExchange) {
			count += (empyWaterBottles/numExchange);
			empyWaterBottles = (empyWaterBottles/numExchange) + (empyWaterBottles % numExchange);
		}
		return count;
	}
}
