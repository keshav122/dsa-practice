package com.roadmap.greedy_algorithms.easy;

import java.util.Arrays;

public class AssignCookies {

    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        Arrays.sort(Student);
        Arrays.sort(Cookie);
        int i = 0;
        int j = 0;
        while (j < Cookie.length && i < Student.length) {
            if (Cookie[j] >= Student[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
