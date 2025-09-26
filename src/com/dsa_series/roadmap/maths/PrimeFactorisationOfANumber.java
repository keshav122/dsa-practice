package com.dsa_series.roadmap.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorisationOfANumber {
    public List<List<Integer>> primeFactors_BF(int[] queries) {
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries) {
            res.add(getPrimeFactors(query));
        }
        return res;
    }

    private List<Integer> getPrimeFactors(int n) {
        List<Integer> ans = new ArrayList<>();
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
            while (prime[i] == 1 && n > 1 && n % i == 0) {
                ans.add(i);
                n = n / i;
            }
        }
        return ans;
    }

    public List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> res = new ArrayList<>();
        int maxi = 0;
        for (int query : queries) {
            maxi = Math.max(query, maxi);
        }
        int[] prime = new int[maxi + 2];
        Arrays.fill(prime, 1);
        for (int i = 2; i * i <= maxi; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= maxi; j += i) {
                    prime[j] = 0;
                }
            }
        }
        for (int q : queries) {
            res.add(getPrimeFactors(prime, q));
        }
        return res;
    }

    private List<Integer> getPrimeFactors(int[] prime, int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (prime[i] == 1 && n > 1 && n % i == 0) {
                ans.add(i);
                n = n / i;
            }
        }
        return ans;
    }

    public List<List<Integer>> primeFactors_optimal(int[] queries) {
        int maxi = 0;
        for (int query : queries) {
            maxi = Math.max(query, maxi);
        }
        int[] spf = new int[maxi + 1];
        for (int i = 1; i < spf.length; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= maxi; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxi; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int q : queries) {
            List<Integer> ans = new ArrayList<>();
            while (q != 1) {
                ans.add(spf[q]);
                q /= spf[q];
            }
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] q = { 5 };
        PrimeFactorisationOfANumber obj = new PrimeFactorisationOfANumber();
        List<List<Integer>> ans = obj.primeFactors_BF(q);
        for (List<Integer> li : ans) {
            for (Integer a : li) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
}
