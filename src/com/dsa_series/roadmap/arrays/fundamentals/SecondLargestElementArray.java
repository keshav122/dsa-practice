/*Author: keshav122 */
package com.dsa_series.roadmap.arrays.fundamentals;

public class SecondLargestElementArray {
    public int secondLargestElement(int[] nums) {
        int largestElement = nums[0];
        int secondLargestElement = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largestElement) {
                secondLargestElement = largestElement;
                largestElement = nums[i];
            } else if (nums[i] < largestElement && nums[i] > secondLargestElement) {
                secondLargestElement = nums[i];
            }
        }
        if (largestElement == secondLargestElement || secondLargestElement == Integer.MIN_VALUE) {
            return -1;
        } else {
            return secondLargestElement;
        }
    }
}
