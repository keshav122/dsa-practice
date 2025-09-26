package com.dsa_series.roadmap.maths;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPrimesInRangeLR {
    public ArrayList<Integer> primesInRange_BF(ArrayList<int[]> queries) {
        int n = (int) (1e6);
        ArrayList<Integer> ans = new ArrayList<>();
        int[] prime = new int[n + 1];
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }

        for (int[] q : queries) {
            ans.add(getCount(prime, q[0], q[1]));
        }
        return ans;
    }

    private int getCount(int[] prime, int l, int r) {
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (prime[i] == 1)
                cnt++;
        }
        return cnt;
    }

    public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
        int n = (int) (1e6);
        ArrayList<Integer> ans = new ArrayList<>();
        int[] prime = new int[n + 1];
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            cnt += prime[i];
            prime[i] = cnt;
        }

        for (int[] q : queries) {
            ans.add(prime[q[1]] - prime[q[0] - 1]);
        }
        return ans;
    }
}
