package com.dsa_series.roadmap.binary_search.FAQs;

public class BookAllocationProblem {
    public int findPages_BF(int[] nums, int m) {
        int minPageCount = Integer.MIN_VALUE;
        int sum = 0;
        // We are calculating the min value of the pageCount as the maximum value of
        // the array because that is the least amount of pages
        // required if the book with highestPageCount is allocated to a student
        for (int num : nums) {
            minPageCount = Math.max(minPageCount, num);
            sum += num;
        }

        for (int page = minPageCount; page <= sum; page++) {
            int students = getStudentsAllocatedCount(nums, page);
            if (students == m) {
                return page;
            }
        }
        return -1;
    }

    public int findPages(int[] nums, int m) {
        if (m > nums.length)
            return -1;
        int minPageCount = Integer.MIN_VALUE;
        int sum = 0;
        // We are calculating the min value of the pageCount as the maximum value of
        // the array because that is the least amount of pages
        // required if the book with highestPageCount is allocated to a student
        for (int num : nums) {
            minPageCount = Math.max(minPageCount, num);
            sum += num;
        }

        int low = minPageCount;
        int high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = getStudentsAllocatedCount(nums, mid);
            if (students >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int getStudentsAllocatedCount(int[] nums, int page) {
        int student = 1;
        int n = nums.length;
        long pagesStudentHas = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudentHas + nums[i] <= page) {
                pagesStudentHas += nums[i];
            } else {
                student++;
                pagesStudentHas = nums[i];
            }
        }
        return student;
    }

    public static void main(String[] args) {
        int[] a = { 12, 34, 67, 90 };
        int m = 2;
        BookAllocationProblem b = new BookAllocationProblem();
        System.out.println(b.findPages_BF(a, m));
    }
}
