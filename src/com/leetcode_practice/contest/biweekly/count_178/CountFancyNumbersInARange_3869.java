/*Author: keshav122 */
package com.leetcode_practice.contest.biweekly.count_178;

public class CountFancyNumbersInARange_3869 {
    public long countFancy(long l, long r) {
        long count = 0;
        for (long i = l; i <= r; i++) {
            if (isFancy(i))
                count++;
        }
        return count;
    }

    private boolean isFancy(long n) {
        if (isGood(n))
            return true;
        int sum = 0;
        while (n > 0) {
            sum += (int) (n % 10);
            n /= 10;
        }
        return isGood(sum);
    }

    private boolean isGood(long n) {
        if (n < 10)
            return true;
        int lastDigit = (int) (n % 10);
        n = n / 10;
        int flag = -1;// - 1 means not set
        while (n > 0) {
            int digit = (int) (n % 10);
            if (digit == lastDigit)
                return false;
            if (flag == -1) {
                if (digit > lastDigit) {
                    flag = 1;
                } else if (digit < lastDigit) {
                    flag = 2;
                }

            }
            if (flag == 1 && digit < lastDigit)
                return false;
            if (flag == 2 && digit > lastDigit)
                return false;
            lastDigit = digit;
            n /= 10;
        }
        return true;
    }
}
