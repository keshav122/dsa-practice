/*Author: keshav122 */
package com.roadmap.beginnerproblems.basic_arrays;

public class CountOfOddNumbersinArray {
    public int countOdd(int[] arr, int n) {
        int oddCount = 0;
        // We iterate over the array and check whether the element is odd
        // If it is odd we add it to the result
        for (int element : arr) {
            if (element % 2 == 1)
                oddCount++;
        }
        return oddCount;
    }
}
