/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

public class NumberOfStudentsDoingHomeWorkAtSameTime_1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i])
                count++;
        }
        return count;
    }
}
