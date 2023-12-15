package com.dsa.basic_1_1;

public class If_Else_Decision_Making {

	public static String compareIfElse(int a, int b) {
        if(a>b){
            return "greater";
        }else if(a<b){
            return "smaller";
        }
        return "equal";
    }
}
