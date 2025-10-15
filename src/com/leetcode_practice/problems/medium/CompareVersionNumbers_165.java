/*Author: keshav122 */
package com.leetcode_practice.problems.medium;

public class CompareVersionNumbers_165 {

	public int compareVersion(String version1, String version2) {
		String[] charArr1 = version1.split("\\.");
		String[] charArr2 = version2.split("\\.");
		int i = 0;
		while (i < Math.min(charArr1.length, charArr2.length)) {
			int char1 = Integer.parseInt(charArr1[i]);
			int char2 = Integer.parseInt(charArr2[i]);
			if (char1 < char2) {
				return -1;
			} else if (char1 > char2) {
				return 1;
			}

			i++;
		}

		while (i < charArr1.length) {
			int char1 = Integer.parseInt(charArr1[i]);
			if (char1 > 0) {
				return 1;
			}
			i++;
		}

		while (i < charArr2.length) {
			int char2 = Integer.parseInt(charArr2[i]);
			if (char2 > 0) {
				return -1;
			}
			i++;
		}

 		return 0;
	}

	public static void main(String[] args) {

	  String version1 = "0.1";
	  String version2 = "1.1";
	  CompareVersionNumbers_165 c = new CompareVersionNumbers_165();
	  System.out.println(c.compareVersion(version1,version2));
	}
}
