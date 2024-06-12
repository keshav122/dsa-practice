package com.dsa.strings.easy;

public class ReverseWordsInAString {
	
	public String reverseWords(String str) {
        String[] words = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i =  words.length -1 ; i > 0 ; i--) {
       	 sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
   }

	public String reverseWords_Better(String str) {
		str = str.stripLeading();
		StringBuilder sb = new StringBuilder();
		int i = str.length() - 1;
		int lastSpaceOccurence = i + 1;
		boolean isWordStarted = false;
		while (i != 0) {
			char c = str.charAt(i);
			if (!isWordStarted && c != ' ') {
				isWordStarted = true;
			} else if (!isWordStarted && c == ' ') {
				lastSpaceOccurence--;
			} else if (isWordStarted && c == ' ') {
				sb.append(str.substring(i + 1, lastSpaceOccurence) + " ");
				lastSpaceOccurence = i;
				isWordStarted = false;
			}
			i--;
		}
		sb.append(str.substring(0, lastSpaceOccurence));
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "  hello world  ";
		ReverseWordsInAString r = new ReverseWordsInAString();
		System.out.println(r.reverseWords(str));
	}
}
