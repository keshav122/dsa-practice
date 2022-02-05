package com.cn.guidedpaths.dsa.strings.mixedproblems;

public class KthCharacterOfDecryptedString {

	public static char kThCharaterOfDecryptedString(String s, Long k) {
		String expand = "";
		String temp = ""; // Current substring
		int freq = 0; // Count of current substring

		for (int i = 0; i < s.length();) {
			temp = ""; // Current substring
			freq = 0; // count frequency of current
						// substring

			// read characters until you find a number
			// or end of string
			while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				// push character in temp
				temp += s.charAt(i);
				i++;
			}

			// read number for how many times string temp will be repeated in
			// decompressed string - Good part
			while (i < s.length() && s.charAt(i) >= '1' && s.charAt(i) <= '9') {
				// generating frequency of temp
				freq = freq * 10 + s.charAt(i) - '0';
				i++;
			}

			// now append string temp into expand equal to its frequency
			for (int j = 1; j <= freq; j++) {
				expand += temp;
			}

		}

		// this condition is to handle the case when string str is ended with
		// alphabet not with numeric value
		if (freq == 0) {
			expand += temp;
		}

		return expand.charAt((int) (k - 1));
	}

	public static char kThCharaterOfDecryptedString1(String s, Long k) {
		int i, j;
		char[] str = s.toCharArray();
		int n = str.length;

		// To store length of substring
		int len;

		// To store length of substring when
		// it is repeated
		int num;

		// To store frequency of substring
		int freq;

		i = 0;

		while (i < n) {
			j = i;
			len = 0;
			freq = 0;

			// Find length of substring by
			// traversing the string until
			// no digit is found.
			while (j < n && Character.isAlphabetic(str[j])) {
				j++;
				len++;
			}

			// Find frequency of preceding substring.
			while (j < n && Character.isDigit(str[j])) {
				freq = freq * 10 + (str[j] - '0');
				j++;
			}

			// Find length of substring when
			// it is repeated.
			num = freq * len;

			// If length of repeated substring is less than
			// k then required character is present in next
			// substring. Subtract length of repeated
			// substring from k to keep account of number of
			// characters required to be visited.
			if (k > num) {
				k -= num;
				i = j;
			}

			// If length of repeated substring is
			// more or equal to k then required
			// character lies in current substring.
			else {
				k--;
				k %= len;
				return str[(int) (i + k)];
			}
		}

		// This is for the case when there
		// are no repetition in string.
		// e.g. str="abced".
		return str[(int) (k - 1)];
	}

	/*
	 * Time Complexity : O(M) Space Complexity : O(M)
	 * 
	 * Where 'M' is the length of the Decrypted String of Encrypted String 'S'
	 */
	public static char kThCharaterOfDecryptedStringOffical1(String s, long k) {
		long i, j;

		// Length of the Encrypted String.
		long n = s.length();

		// To store the frequency of the substring.
		long freqOfSubstring;

		// Decrypted String
		StringBuilder decryptedString = new StringBuilder();

		i = 0;

		while (i < n) {
			j = i;
			StringBuilder substring = new StringBuilder();
			freqOfSubstring = 0;

			// Find the substring by traversing the string until no digit is
			// found.
			while (j < n && Character.isLowerCase(s.charAt((int) j))) {
				substring.append(s.charAt((int) j));
				j++;
			}

			// Find the frequency of preceding substring.
			while (j < n && Character.isDigit(s.charAt((int) j))) {
				freqOfSubstring = freqOfSubstring * 10 + (s.charAt((int) j) - '0');
				j++;
			}

			i = j;

			// Append the subtring freqOfSubstring times
			while (freqOfSubstring-- > 0) {
				decryptedString.append(substring);
			}
		}

		// Return 'k'Th character of Decrypted String
		return decryptedString.charAt((int) (k - 1));
	}

	/*
	 * Time Complexity : O(N) Space Complexity : O(1)
	 * 
	 * Where 'N' is the length of Encrypted String 'S'
	 */
	public static char kThCharaterOfDecryptedStringOfficalSolutionImprovised(String s, Long k) {
		long i, j;

		// Length of the Encrypted String.
		long n = s.length();

		// To store the length of the substring.
		long substringLength;

		// To store the resultant length of the repeated substring.
		long resultantLength;

		// To store the frequency of the substring.
		long freqOfSubstring;

		// 'k'th Character in Decrypted String.
		char kThChar = '$';

		i = 0;

		while (i < n) {
			j = i;
			substringLength = 0;
			freqOfSubstring = 0;

			// Find the length of substring by traversing the string until no
			// digit is
			// found.
			while (j < n && Character.isLowerCase(s.charAt((int) j))) {
				j++;
				substringLength++;
			}

			// Find the frequency of preceding substring.
			while (j < n && Character.isDigit(s.charAt((int) j))) {
				freqOfSubstring = freqOfSubstring * 10 + (s.charAt((int) j) - '0');
				j++;
			}

			// Find length of the resultant length of the repeated substring.
			resultantLength = freqOfSubstring * substringLength;

			if (k > resultantLength) {
				/*
				 * If length of the repeated substring is less than 'k' then
				 * required character is present in later substring. Subtract
				 * the length of repeated substring from 'k' to keep account of
				 * number of characters required to be visited.
				 */

				k -= resultantLength;
				i = j;
			} else {
				/*
				 * If length of repeated substring is more or equal to 'k' then
				 * required character lies in current substring.
				 */

				k--;
				k %= substringLength;
				kThChar = s.charAt((int) (i + k));
				break;
			}
		}

		return kThChar;
	}

	public static void main(String[] args) {
		String str = "a2b3cd3";
		long K = 8;
		char c = kThCharaterOfDecryptedString(str, K);
		System.out.println(c);
	}
}
