package com.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> oneRow = new ArrayList<>();
		oneRow.add(1);
		res.add(oneRow);
		if (numRows == 1) {
			return res;
		}
		List<Integer> secondRow = new ArrayList<>();
		secondRow.add(1);
		secondRow.add(1);
		res.add(secondRow);
		if (numRows == 2) {
			return res;
		}
		for (int i = 2; i < numRows; i++) {
			List<Integer> currRow = new ArrayList<>();
			currRow.add(1);
			// for loop
			for (int j = 1; j < i; j++) {
				List<Integer> lastRow = res.get(i - 1);
				currRow.add(lastRow.get(j - 1) + lastRow.get(j));
			}
			currRow.add(1);
			res.add(currRow);
		}
		return res;
	}
	
	public List<List<Integer>> generateOptimal(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 1; i <= numRows; i++) {
			res.add(returnRowOfPascalTriangle(i));
		}
		return res;
	}
	
	public static List<Integer> returnRowOfPascalTriangle(int row) {
		List<Integer> li = new ArrayList<>();
		int a = 1;
		li.add(1);
		for (int i = 1; i < row; i++) {
			a = a * (row - i);
			a /= i;
			li.add(a);
		}
		return li;
	}

}
