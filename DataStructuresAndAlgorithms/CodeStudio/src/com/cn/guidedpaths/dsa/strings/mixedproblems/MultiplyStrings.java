/*Author: keshav122 */
package com.cn.guidedpaths.dsa.strings.mixedproblems;

import java.util.ArrayList;

public class MultiplyStrings {
	public static String multiplyStrings(String a, String b) {

		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();

		for (int i = a.length() - 1; i >= 0; i--) {
			arr1.add(Character.getNumericValue(a.charAt(i)));
		}

		for (int i = b.length() - 1; i >= 0; i--) {
			arr2.add(Character.getNumericValue(b.charAt(i)));
		}

		int res[] = new int[arr1.size() + arr2.size() - 1];
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				int val = arr1.get(i) * arr2.get(j);
				res[i + j] += val;
			}
		}

		for (int i = 0; i < res.length; i++) {
			if (res[i] > 9) {
				int temp = res[i];
				res[i] = temp % 10;
				res[i + 1] = res[i + 1] + temp / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = res.length - 1; i >= 0; i--) {
			sb.append(res[i]);
		}
		
		if(allZero(sb.toString())){
			return "0";
		}
		return sb.toString();
	}

	public static boolean allZero(String str){
		for(int i = 0; i< str.length();i++){
			if(str.charAt(i) != '0'){
				return false;
			}
		}
		return true;
	}
}
