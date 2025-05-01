package com.contest.weekly.count_372;

public class Swap_Black_and_White {

	public long minimumSteps(String s) {
		  long count = 0;
          char[] ballsArray = s.toCharArray();
           boolean isAllSwapped = isAllInOrder(ballsArray);
           while(!isAllSwapped) {
        	   for(int i = 0; i< ballsArray.length-1;i++) {
        		   if(ballsArray[i] == '1' && ballsArray[i+1] == '0') {
       				ballsArray[i+1] = '1';
       				ballsArray[i] = '0';
       				count++;
       			}
        	   }
        	   isAllSwapped = isAllInOrder(ballsArray);
           }
          return count;
	}

	public long minimumSteps_Str(String s) {
		  long count = 0;
         boolean isAllSwapped = isAllInOrder(s);
         while(!isAllSwapped) {
      	   for(int i = 0; i< s.length()-1;i++) {
      		   if(s.charAt(i) == '1' && s.charAt(i+1) == '0') {
      			    String temp = s.substring(0,i);
     				temp += "01";
     				count++;
     				if(i+ 1 < s.length()) {
     					temp += s.substring(i+2,s.length());
     					
     				}
     				s= temp;
     				temp = "";
     			}
      	   }
      	   isAllSwapped = isAllInOrder(s);
         }
        return count;
	}
	
	
	private boolean isAllInOrder(String s) {
		for(int i = 0; i < s.length()-1;i++) {
			 if(s.charAt(i)== '1' && s.charAt(i+1) == '0') {
				return false;
			}
		}
		return true;
	}
	
	
	private boolean isAllInOrder(char[] arr) {
		for(int i = 0; i < arr.length-1;i++) {
			 if(arr[i] == '1' && arr[i+1] == '0') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "100";
		Swap_Black_and_White s = new Swap_Black_and_White();
		System.out.println(s.minimumSteps_Str(str));
	}
}
