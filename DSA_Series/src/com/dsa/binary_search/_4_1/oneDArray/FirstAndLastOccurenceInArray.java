package com.dsa.binary_search._4_1.oneDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccurenceInArray {

	public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
		int[] ans = new int[2];
		int start = 0;
		int end = n - 1;
		boolean isFound = false;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr.get(mid) == k) {
				isFound = true;
				int left = mid;
				int right = mid;
				if (left == 0) {
					ans[0] = 0;
				} else {
					while (left >= 0 && arr.get(left) == k) {
						left--;
					}
					ans[0] = left + 1;
				}
				if (right == n - 1) {
					ans[1] = n - 1;
				} else {
					while (right < n && arr.get(right) == k) {
						right++;
					}
					ans[1] = right - 1;
				}

				if (isFound) {
					return ans;
				}
			} else if (arr.get(mid) > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (!isFound) {
			ans[0] = ans[1] = -1;
		}
		return ans;
	}

	public static int[] firstAndLastPosition_Way1(ArrayList<Integer> arr, int n, int k) {
		int ans[] = new int[2];
		ans[0] = firstOcc(arr,n,k);
		//Minor update
		if(ans[0] == -1) {
			ans[1] = -1;
			return ans;
		}
		ans[1] = lastOcc(arr,n,k);
		return ans;
	}
	private static int lastOcc(ArrayList<Integer> arr, int n, int k) {
		int low = 0;
		int high = n-1;
		int ans = -1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr.get(mid) == k) {
				ans = mid;
				low = mid + 1;
			}else if(arr.get(mid) > k) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static int firstOcc(ArrayList<Integer> arr, int n, int k) {
		int low = 0;
		int high = n-1;
		int ans = -1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr.get(mid) == k) {
				ans = mid;
				high = mid - 1;
			}else if(arr.get(mid) > k) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return ans;
	}

	//Using the upper bound and the lower bound
	public static int[] firstAndLastPosition_Optimal(ArrayList<Integer> arr, int n, int k) {
		int ans[] = new int[2];
		int lb = lowerBound(arr, n, k);
		if(lb == n || arr.get(lb) != k) {
			return ans;
		}
		int ub = upperBound(arr, n, k);
		ans[0] = lb;
		ans[1] = ub-1;
		return ans;
	}
	public static int lowerBound(ArrayList<Integer> arr, int n, int k) {
		//Even if we don't find anything we will place the value @ index n
		int ans = n;
		int low = 0;
		int high = n-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr.get(mid) >= k) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid+1;
			}
		}
		return ans;
	}
	
	public static int upperBound(ArrayList<Integer> arr, int n, int x) {
		int ans = n;
		int low = 0;
		int high = n-1;
		while(low <= high) {
		  int mid = (low + high)/2;
		  if(arr.get(mid) > x) {
			  ans = mid;
			  high = mid-1;
		  }else {
			  low = mid + 1;
		  }
		}
		return ans;
	}
	public static void main(String[] args) {
//		9 3
//		3 4 4 4 5 5 5 5 5 
		
		//3 3 4 4 5 5 6 6 6 6 
		List<Integer> temp = Arrays.asList(3, 3, 4, 4, 5, 5, 6, 6, 6,6);
		ArrayList<Integer> li = new ArrayList<>();
		li.addAll(temp);
		int res[] = firstAndLastPosition_Optimal(li, li.size(), 3);
		for (int i : res) {
			System.out.println(i + " ");
		}
	}

}