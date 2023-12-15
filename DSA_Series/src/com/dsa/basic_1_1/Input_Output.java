package com.dsa.basic_1_1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class Input_Output {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		System.out.println(x);
		s.close();
		
		// BufferedReader
		// InputStreamReader class - converts raw byte based input stream to character based stream
		InputStreamReader is = new InputStreamReader(System.in);
		
		//BufferedReader is used to buffer the input stream making it more efficient to read lines of text
		BufferedReader in = new BufferedReader(is);
		
		int num = Integer.parseInt(in.readLine());
		
		
	}
}
