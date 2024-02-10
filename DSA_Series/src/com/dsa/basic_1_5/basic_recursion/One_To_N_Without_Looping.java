package com.dsa.basic_1_5.basic_recursion;

public class One_To_N_Without_Looping {

	public static int[] printNos_Way1(int x) {
		if(x== 1) {
			int a[] = new int[1];
			a[0] = 1;
			return a;
		}
		int[] smallAns = printNos_Way1(x-1);
		int[] ans= new int[x];
		for(int i = 0; i< smallAns.length;i++) {
			ans[i] = smallAns[i];
		}
		ans[x-1] = x;
		return ans;
	}
	
	public static int[] printNos(int x) {
		int ans[] = new int[x];
		printNos(ans,x);
		return ans;
	}

	
	private static void printNos(int[] ans, int x) {
		if(x <= 0) return ;
		printNos(ans,x-1);
		ans[x-1] = x;
		
	}

	public static void main(String[] args) {
		int a[] = printNos(5);
		for(int i : a) {
			System.out.print(i+" ");
		}
	}
}
