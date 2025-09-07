/*Author: keshav122 */
package com.contests.codeforces.round_985;

/*Author: keshav122 */
import java.util.Scanner;

public class Set {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            int T = s.nextInt();
            while (T-- > 0) {
                long left = s.nextInt();
                long right = s.nextInt();
                long k = s.nextInt();
                System.out.println(getMaxOperationsPossible(left, right, k));
            }
            s.close();
        } catch (Exception e) {

        }
    }

    private static int getMaxOperationsPossible(long left, long right, int k) {
        int ans = 0;
        long low = left;
        long high = right;
        while (low <= high) {
            long mid = (low + high) / 2;
            long value = mid * k;
            if (value > right) {
                high = mid - 1;
            } else {
                ans = (int) mid;
                low = mid + 1;
            }
        }
        if (ans == 0)
            return 0;
        return (ans - left + 1);
    }
}
