package com.cn.guidedpaths.dsa.strings.mixedproblems;

import java.math.BigInteger;

public class CompareVersions {

	public static int compareVersions(String a, String b) {
		String[] listA = a.split("\\.");
		String[] listB = b.split("\\.");

		    int len = Math.min(listA.length, listB.length);
			for (int i = 0; i <len ; i++) {
				BigInteger a1 = new BigInteger(listA[i]);
				BigInteger b1 = new BigInteger(listB[i]);
				if (a1.compareTo(b1) != 0) {
					return a1.compareTo(b1);
				} else{
					continue;
				}
			}
			
			if(len != listA.length){
				for(int i = len; i< listA.length;i++){
					int temp = Integer.parseInt(listA[i]);
					if(temp != 0){
						return 1;
					}
				}
				return 0;
			}
		
			if(len != listB.length){
				for(int i = len; i< listB.length;i++){
					int temp = Integer.parseInt(listB[i]);
					if(temp != 0){
						return -1;
					}
				}
				return 0;
			}

		return 0;
	}
}
