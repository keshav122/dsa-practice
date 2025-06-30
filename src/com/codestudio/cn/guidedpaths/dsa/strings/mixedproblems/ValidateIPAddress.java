package com.codestudio.cn.guidedpaths.dsa.strings.mixedproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {

	public static boolean isValidIPv4(String ipAddress) {
		String[] strArray = ipAddress.split("\\.");
		if(strArray.length != 4){
			return false;
		}
		
		for(String str : strArray){
			String regex = "[0-9]+";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			if(!m.matches()){
				return false;
			}else{
				int temp = Integer.parseInt(str);
				if(temp >= 0 && temp <= 255){
					continue;
				}else{
					return false;
				}
			}
		}
		return true;
	}

}
