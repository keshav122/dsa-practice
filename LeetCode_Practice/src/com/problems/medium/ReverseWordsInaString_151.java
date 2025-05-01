package com.problems.medium;

public class ReverseWordsInaString_151 {

	public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i =  words.length -1 ; i > 0 ; i--) {
       	 sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
   }
	

	public String reverseWords_better(String s) {
		s = s.stripLeading();
		StringBuilder sb = new StringBuilder();
		int i = s.length() - 1;
		int lastSpaceOccurence = i + 1;
		boolean isWordStarted = false;
		while (i != 0) {
			char c = s.charAt(i);
			if (!isWordStarted && c != ' ') {
				isWordStarted = true;
			} else if (!isWordStarted && c == ' ') {
				lastSpaceOccurence--;
			} else if (isWordStarted && c == ' ') {
				sb.append(s.substring(i + 1, lastSpaceOccurence) + " ");
				lastSpaceOccurence = i;
				isWordStarted = false;
			}
			i--;
		}
		sb.append(s.substring(0, lastSpaceOccurence));
		return sb.toString();
	}
}
