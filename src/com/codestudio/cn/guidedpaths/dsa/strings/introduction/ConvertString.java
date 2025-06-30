package com.codestudio.cn.guidedpaths.dsa.strings.introduction;



public class ConvertString {

	public static String convertString(String str) {
      String[] li = str.split("\\s+");
      String res = "";
      int i = 0;
      while( i< li.length-1){
    	  res += li[i].toUpperCase().substring(0, 1)+li[i].substring(1)+" ";
    	  i++;
      }
      res += li[i].toUpperCase().substring(0, 1)+li[i].substring(1);
      return res;
  }
	
}
