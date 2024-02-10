package com.dsa.basic_1_2.patterns;

public class Patterns {

	public static void pattern1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}

	public static void pattern2(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}

	public static void pattern3(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void pattern4(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void pattern5(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}

	public static void pattern5_alternateWay(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}

	public static void pattern6(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void pattern6_alternateWay(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void pattern7(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= ((2 * i) - 1); k++) {
				System.out.print("*");
			}
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void pattern8(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= ((2 * i) - 1); k++) {
				System.out.print("*");
			}
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void pattern9(int n) {
		pattern7(n);
		pattern8(n);
	}

	public static void pattern10(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void pattern10_alternateWay(int n) {
		for (int i = 1; i <= 2 * n - 1; i++) {
			int stars = i;
			if (i > n) {
				stars = 2 * n - i;
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void pattern11(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				int sum = i + j;
				if (sum % 2 == 0) {
					System.out.print("1" + " ");
				} else {
					System.out.print("0" + " ");
				}

			}
			System.out.println();
		}
	}

	public static void pattern11_alternateWay(int n) {
		int start = 1;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				start = 1;
			} else {
				start = 0;
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(start + " ");
				start = 1 - start; // for flipping 1 to 0 and 0 to 1
			}
			System.out.println();
		}
	}

	public static void pattern12(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" " + " ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void pattern13(int n) {
		int count = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(count + " ");
				count++;

			}
			System.out.println();
		}
	}

	public static void pattern14(int n) {
		for (int i = 1; i <= n; i++) {
			char letter = 'A';
			for (int j = 1; j <= i; j++) {
				System.out.print(letter + " ");
				letter = (char) (letter + 1);

			}
			System.out.println();
		}
	}

	public static void pattern14_improved(int n) {
		for (int i = 1; i <= n; i++) {
			for (char c = 'A'; c < 'A' + i; c++) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

	public static void pattern15(int n) {
		for (int i = n; i >= 1; i--) {
			char letter = 'A';
			for (int j = 1; j <= i; j++) {
				System.out.print(letter + " ");
				letter = (char) (letter + 1);

			}
			System.out.println();
		}
	}

	public static void pattern15_improved(int n) {
		for (int i = n; i >= 1; i--) {
			for (char c = 'A'; c < 'A' + i; c++) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	public static void pattern16(int n) {
		char letter = 'A';
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(letter + " ");
			}
			letter = (char) (letter + 1);
			System.out.println();
		}
	}

	public static void pattern16_improved(int n) {
		for (int i = 0; i < n; i++) {
			char c = (char) ('A' + i);
			for (int j = 0; j <= i; j++) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	public static void pattern17(int n) {
		for (int i = 1; i <= n; i++) {
			char letter = 'A';
			int preSpace = 2 * (n - i);
			int postSpace = 2 * (n - i) + 1;
			for (int j = 1; j <= preSpace; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(letter + " ");
				letter = (char) (letter + 1);
			}

			letter = (char) (letter - 2);

			while (letter >= 'A') {
				System.out.print(letter + " ");
				letter = (char) (letter - 1);
			}

			for (int j = 1; j <= postSpace; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void pattern17_improved(int n) {
		for(int i = 0; i< n ; i++) {
			//(n-i) spaces
			for (int j = 0; j < (n-i-1); j++) {
				System.out.print(" ");
			}
			
			//2 * i + 1 characters
			char c = 'A';
			int breakPoint = (2 * i + 1)/2;
			for (int j = 1; j <= (2 * i + 1); j++) {
				System.out.print(c+" ");
				if(j <= breakPoint) c++;
				else c--;
			}
			
			//(n-i) spaces
			for (int j = 0; j < (n-i-1); j++) {
				System.out.print(" ");
			}
			
			System.out.println();
		}
	}
	
	
	public static void pattern18(int n) {
		for (int i = 1; i <= n; i++) {
			char letter = (char) ('A' + (n - 1));
			for (int j = 1; j <= i; j++) {
				System.out.print(letter + " ");
				letter--;
			}
			System.out.println();
		}
	}
	
	
	public static void pattern19(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (n - i); j++) {
				System.out.print("* ");
			}
			for (int j = 0; j < 2 * i; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < (n - i); j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < (n - i); j++) {
				System.out.print("* ");
			}
			for (int j = 0; j < 2 * i; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < (n - i); j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	public static void pattern20(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			for (int j = 0; j < 2 * (n - i); j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			for (int j = 0; j < 2 * (n - i); j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	public static void pattern20_improved(int n) {
		int spaces = 2 * n - 2;
		for(int i = 1; i<= 2* n-1 ;i++) {
			//stars
			int stars = i;
			if(i > n) stars = 2* n - i;
			for(int j = 1; j<=stars;j++) {
				System.out.print("* ");
			}
			
			//spaces
			for(int j = 1; j<=spaces;j++) {
				System.out.print("  ");
			}
			
			//stars
			for(int j = 1; j<=stars;j++) {
				System.out.print("* ");
			}
			System.out.println();
			if(i < n) spaces -= 2;
			else spaces +=  2;
			
		}
	}
	
	public static void pattern21(int n) {
		for (int i = 1; i <= n; i++) {
			if (i == 1 || i == n) {
				for (int j = 1; j <= n; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				System.out.print("*");
				for (int j = 0; j < n / 2; j++) {
					System.out.print(" ");
				}
				System.out.print("* ");
				for (int j = 0; j < n / 2; j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}

	public static void pattern21_improved(int n) {
		for(int i = 0; i< n ; i++) {
			for(int j = 0; j< n ; j++) {
				if(i == 0 || i == n-1 || j == 0 || j == n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void pattern22(int n) {
		for(int i = 0; i < 2 * n - 1; i++) {
			for(int j = 0; j < 2 * n - 1; j++) {
				int topDist = i;
				int leftDist = j;
				int rightDist = (2 * n-2)-j;//2 * n -2 represents the last index
				int downDist = (2 * n - 2)- i;
				int val = n - Math.min(Math.min(topDist, downDist), Math.min(leftDist, rightDist));
				System.out.print(val);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 4;
		pattern22(n);
	}

}
