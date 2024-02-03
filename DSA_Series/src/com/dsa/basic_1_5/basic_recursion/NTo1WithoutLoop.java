package com.dsa.basic_1_5.basic_recursion;

public class NTo1WithoutLoop {

    public static int[] printNos(int x) {
        int a[] = new int[x];
        printNos(a,x,0);
        return a;
    }

	private static void printNos(int[] a, int x,int i) {
		if(x == 0) return;
		 a[i] = x;
		 
	     printNos(a, x-1, ++i);
	}

	public static void main(String[] args) {
		int a[] = printNos(5);
		for(int i : a) {
			System.out.print(i+" ");
		}
	}
}
