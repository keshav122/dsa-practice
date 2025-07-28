/*Author: keshav122 */
package com.dsa_series.roadmap.sliding_window_and_two_pointers.counting_subarrays_substrings_problems;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings_BF(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[3];
            int characterCount = 0;
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j) - 'a'] == 0) {
                    hash[s.charAt(j) - 'a']++;
                    characterCount++;
                }
                if (characterCount == 3) {
                    count += n - j;
                    break;
                }
            }
        }
        return count;
    }

    public int numberOfSubstrings_Better(String s) {
        int n = s.length();
        int count = 0, l = 0, r = 0, characterCount = 0;
        int[] hash = new int[3];
        while (r < n) {
            if (hash[s.charAt(r) - 'a'] == 0) {
                characterCount++;
            }
            hash[s.charAt(r) - 'a']++;
            if (characterCount == 3) {
                count += n - r;
            }
            while (characterCount == 3) {
                hash[s.charAt(l) - 'a']--;
                if (hash[s.charAt(l) - 'a'] == 0) {
                    characterCount--;
                }
                if (characterCount == 3) {
                    count += n - r;
                }
                l++;
            }
            r++;
        }
        return count;
    }

    public int numberOfSubstrings_Optimal(String s) {
        int n = s.length(), count = 0;
        int[] lastSeen = { -1, -1, -1 };
        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += (1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]));
            }
        }
        return count;
    }

}
