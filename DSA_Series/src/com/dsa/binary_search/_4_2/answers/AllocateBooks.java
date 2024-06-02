package com.dsa.binary_search._4_2.answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllocateBooks {

	/*
	 * The approach is that we decide on the number of pages each student has the
	 * capability to hold If we start with a value less than the maximum number of
	 * pages in the array then we will not be able to store all books so that will
	 * serve as the minimum no of pages whereas the worst case scenario is that
	 * there is only one student and all the books are assigned to him.
	 * 
	 */
	public static int findPages(ArrayList<Integer> arr, int n, int m) {
		if(m > n) return -1;
		int minPages = Collections.max(arr);
		// TODO Need to learn more on the intermediate functions used in stream
		int maxPages = arr.stream().mapToInt(Integer::intValue).sum();
		for (int pages = minPages; pages < maxPages; pages++) {
			if (countStudents(arr, pages, n) == m) {
				return pages;
			}
		}
		return maxPages;

	}
	
	public static int findPagesBS(ArrayList<Integer> arr, int n, int m) {
		if(m > n) return -1;
		int minPages = Collections.max(arr);
		int maxPages = arr.stream().mapToInt(Integer::intValue).sum();
		while(minPages <= maxPages) {
			int midPages = (minPages + maxPages)/2;
			if (countStudents(arr, midPages, n) <= m) {
				maxPages = midPages-1;
			}else {
				minPages = midPages + 1;
			}
		}
		return minPages;

	}

	private static int countStudents(ArrayList<Integer> arr, int pages, int n) {
		int student = 1;
		long pagesStudentHas = 0;
		for (int i = 0; i < n; i++) {
			if (pagesStudentHas + arr.get(i) <= pages) {
				pagesStudentHas += arr.get(i);
			} else {
				student++;
				pagesStudentHas = arr.get(i);
			}
		}
		return student;
	}
	
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(25 ,46, 28 ,49, 24);
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(arr);
		int ans = findPagesBS(a, 5, 4);
		System.out.println(ans);
	}

}
