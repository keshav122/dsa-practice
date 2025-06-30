package com.dsa_series.roadmap.arrays.FAQs_Hard;

import java.util.HashMap;
import java.util.Map;

public class FindRepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbers_BF(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
            if (count == 2) {
				repeating = i;
			} else if (count == 0) {
				missing = i;
			}

            if (missing != -1 && repeating != -1) {
                ans[0] = repeating;
                ans[1] = missing;
                break;
            }

        }
        return ans;
    }

    public int[] findMissingRepeatingNumbers_hashing(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
				ans[1] = i;
			}
            if (hash[i] == 2) {
				ans[0] = i;
			}
            if (ans[0] != 0 && ans[1] != 0) {
				break;
			}
        }
        return ans;
    }

    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        long naturalSum = ((n + 1) * n) / 2;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (map.containsKey(num)) {
                ans[0] = num;
            } else {
                map.put(num, 1);
            }
        }
        if (sum > naturalSum) {
            ans[1] = (int) (ans[0] - (sum - naturalSum));
        } else {
            ans[1] = (int) (ans[0] + (naturalSum - sum));
        }

        return ans;
    }

    public int[] findMissingRepeatingNumbers_Optimal1(int[] nums) {
        // S-Sn where Sn is the sum of first n natural numbers which is (n * (n+1))/2
        // S^2 -Sn^2 where Sn^2 is the sum of squares of first n natural numbers which
        // is (n* (n+1) * (2n + 1))/6

        long n = nums.length;
        long sum = 0, sumSquared = 0;
        long Sn = (n * (n + 1)) / 2;
        long SnSq = (n * (n + 1) * (2 * n + 1)) / 6;
        for (int num : nums) {
            sum += num;
            sumSquared += (long) (num) * (long) (num);
        }
        long val1 = sum - Sn;// x-y
        long val2 = sumSquared - SnSq;
        val2 = (val2 / val1);// x+y
        long x = (val1 + val2) / 2;
        long y = x - val1;
        return new int[] { (int) x, (int) y };
    }

    public int[] findMissingRepeatingNumbers_Optimal2(int[] nums) {
        // We first do the xor of all the array numbers with the first n natural numbers
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            xor ^= (i + 1);
        }
        // int bitNo = 0;
        // while(1){
        // if((xor & (1 << bitNo)) != 0){
        // break;
        // }
        // bitNo++;
        // }
        // Shortcut to find the rightmost set bit
        int number = (xor & ~(xor - 1));
        // Segregate the numbers into two groups - zero and one
        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            // part of oneth group
            // We can also do if ((nums[i] & (1 << bitNo)) != 0) {
            if ((nums[i] & number) != 0) {
                one = one ^ nums[i];
            } else {
                zero = zero ^ nums[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            // part of oneth group
            if ((i & number) != 0) {
                one = one ^ i;
            } else {
                zero = zero ^ i;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == one) {
				count++;
			}
        }
        if (count == 2) {
			return new int[] { one, zero };
		}
        return new int[] { zero, one };

    }
}
