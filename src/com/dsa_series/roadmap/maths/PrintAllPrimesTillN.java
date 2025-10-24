/*Author: keshav122 */
package com.dsa_series.roadmap.maths;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllPrimesTillN {
    public ArrayList<Integer> primeTillN_BF(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(2);
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public ArrayList<Integer> primeTillN(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] prime = new int[n + 2];
        Arrays.fill(prime, 1);
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i] == 1)
                ans.add(i);
        }
        return ans;

    }
}
