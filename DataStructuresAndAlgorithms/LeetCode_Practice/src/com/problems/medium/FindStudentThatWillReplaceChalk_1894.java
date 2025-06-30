package com.problems.medium;

public class FindStudentThatWillReplaceChalk_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        // calculate prefix sum
        long sum = 0;
        for (int ch : chalk) {
            sum += ch;
        }
        int rounds = (int) (k / sum);
        k -= rounds * sum;
        for (int i = 0; i < n; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}
