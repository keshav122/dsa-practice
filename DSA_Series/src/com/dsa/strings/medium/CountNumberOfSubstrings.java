package com.dsa.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubstrings {

	long substrCount_BF(String s, int K) {
		long ans = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				String substring = s.substring(i, j + 1);
                 if(getCount(substring) == K) {
                	 ans++;
                 }
			}
		}
		return ans;
	}

	private int getCount(String str) {
		Map<Character,Integer> charMap = new HashMap<>();
		for(int i = 0; i< str.length(); i++) {
			charMap.merge(str.charAt(i), 1, Integer::sum);
		}
		return charMap.keySet().size();
	}
	
	long substrCount_Better(String s, int K) {
		long ans = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int[] characterMap = new int[26];
			int distinctChar = 0;
			for (int j = i; j < n; j++) {
				if(characterMap[s.charAt(j)-'a'] == 0) {
					characterMap[s.charAt(j)-'a']++;
					distinctChar++;
				}
				if(distinctChar == K) {
					ans++;
				}
                 
			}
		}
		return ans;
	}
	
	long substrCount(String s, int k) {
		long ans = 0;
		if(k == 1) {
			return substrCountForKOne(s,1);
		}
		int n = s.length();
		HashMap<Character,Integer> smallMap = new HashMap<>();
		HashMap<Character,Integer> bigMap = new HashMap<>();
		int iS= -1;//smallMapAcquiringIndex 
		int iL = -1; //largeMapAcquiringIndex 
		int iR = -1;//releasingIndex
		
		while(true) {
			boolean flag1 = false, flag2 = false, flag3 = false;
			while(iL < n-1) {
				iL++;
				flag1 = true;
				char c = s.charAt(iL);
				bigMap.merge(c, 1, Integer::sum);
				
				if(bigMap.size() == k+1) {
					removeCharFromMap(bigMap,c);
					iL--;
					break;
				}
			}
			
			while(iS < iL) {
				iS++;
				flag2 = true;
				char c = s.charAt(iS);
				smallMap.merge(c, 1, Integer::sum);
				
				if(smallMap.size() == k) {
					removeCharFromMap(smallMap,c);
					iS--;
					break;
				}
			}
			
			while(iR < iS) {
				flag3 = true;
				if(smallMap.size() == k && bigMap.size() == k+1) {
					ans += iL-iS;
				}
				iR++;
				char c = s.charAt(iR);
				removeCharFromMap(smallMap,c);
				removeCharFromMap(bigMap,c);
				
				if(smallMap.size() < k-1 || bigMap.size() <k) {
					break;
				}
			}
			
			if(flag1 == false && flag2 == false && flag3 == false) {
				break;
			}
			
		}
		return ans;
	}

	private long substrCountForKOne(String s, int i) {
		int n = s.length();
		HashMap<Character,Integer> map = new HashMap<>();
		int iA = -1;
		int iR = -1;
		long ans = 0;
	    while(true) {
	    	boolean flag1 = false , flag2 = false;
	    	while(iA < n-1) {
	    		flag1 = true;
				iA++;
				char c = s.charAt(iA);
				map.merge(c, 1, Integer::sum);
				
				if(map.size() == 2) {
					removeCharFromMap(map,c);
					iA--;
					break;
				}
			}
	    	
	    	while(iR < iA) {
	    		flag2 = true;
				if(map.size() == 1) {
					ans += iA-iR;
				}
				iR++;
				char c = s.charAt(iR);
				removeCharFromMap(map,c);
				if(map.size() == 0) {
					break;
				}
			}
	    	
	    	if(flag1 == false && flag2 == false) {
	    		break;
	    	}
	    }
		return ans;
	}

	private void removeCharFromMap(HashMap<Character, Integer> bigMap, char c) {
		if(bigMap.get(c) == 1) {
			bigMap.remove(c);
		}else {
			bigMap.put(c, bigMap.get(c) -1);
		}
	}

	public static void main(String[] args) {
		String str = "aba";
		CountNumberOfSubstrings obj = new CountNumberOfSubstrings();
		System.out.println(obj.substrCount(str, 2));
	}
}
