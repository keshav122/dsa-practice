package com.problems.easy;

public class PassThePillow_2582 {

	public int passThePillow(int n, int time) {
		int div = time / (n - 1);
		return (div % 2 == 0) ?  (time % (n - 1)) + 1 :  (n - (time % (n - 1)));
	}
}
