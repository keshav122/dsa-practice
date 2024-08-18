package com.roadmap.basic_maths;

public class PrimeUptoN {
    public int primeUptoN(int n) {
        // We create a boolean array of size n
        boolean[] prime = new boolean[n + 1];
        // We mark all the fields as true
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        // We start from i =2 and mark all the values for its square and then a distance
        // of i as false
        // Because those will be divisible by i
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        // All the non-marked values are now the prime numbers upto n
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        PrimeUptoN p = new PrimeUptoN();
        System.out.println(p.primeUptoN(n));
    }
}
