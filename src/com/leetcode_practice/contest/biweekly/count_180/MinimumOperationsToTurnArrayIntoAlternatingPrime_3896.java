package com.leetcode_practice.contest.biweekly.count_180;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumOperationsToTurnArrayIntoAlternatingPrime_3896 {
    public int minOperations(int[] nums) {
        // even - prime
        // odd - non prime
        int maxVal = 100100;
        int n = nums.length;
        int ops = 0;
        Set<Integer> allPrimes = primeTillN(maxVal);
        List<Integer> primes = new ArrayList<>();
        primes.addAll(allPrimes);
        Collections.sort(primes);
        int size = allPrimes.size();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (!allPrimes.contains(nums[i])) {
                    int nPrime = findNearestPrime(primes, nums[i], size);
                    ops += nPrime - nums[i];
                }
            } else {
                if (allPrimes.contains(nums[i])) {
                    if (nums[i] == 1)
                        ops += 3;
                    else if (nums[i] == 2)
                        ops += 2;
                    else
                        ops++;
                }
            }
        }
        return ops;
    }

    private int findNearestPrime(List<Integer> primes, int i, int size) {
        int low = 0, high = size - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (primes.get(mid) > i) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return primes.get(ans);

    }

    public Set<Integer> primeTillN(int n) {
        Set<Integer> ans = new HashSet<>();
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

    public int minOperations_optimal(int[] nums) {
        boolean[] isPrime;
        int[] nextPrime;

    }
}