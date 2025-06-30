package com.codestudio.cn.guidedpaths.dsa.arrays.prefixandsuffixsum;

import java.util.ArrayList;

public class XORQuery {

	public static ArrayList<Integer> xorQuery(ArrayList<ArrayList<Integer>> queries) {
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> xorList = new ArrayList<>();
		for (ArrayList<Integer> li : queries) {
			int type = li.get(0);
			int value = li.get(1);
			if (type == 1) {
				result.add(value);
			} else {
				if (!xorList.isEmpty()) {
					xorList.set(0, xorList.get(0) ^ value);
				} else {
					xorList.add(value);
				}
			}

		}
		for (int j = 0; j < result.size(); j++) {
			result.set(j, result.get(j) ^ xorList.get(0));
		}
		return result;
	}

}

/*
 * Time Complexity: O(Q) Space Complexity: O(Q)
 * 
 * Where 'Q' is the number of queries
 * 
 * We derive the basic idea for this approach from the problem where we are
 * given a range L to R and we have to add a number to all the elements in this
 * range in the given array, to solve this we maintain a prefix array
 * (initialized with all 0�s) and we add that number at index L and we subtract
 * that number at index R+1 in the prefix array and then we compute the
 * cumulative sum(i.e prefix[i] = prefix[i]+prefix[i-1]), (so that the number is
 * added to all elements from index L to R, and not afterward) of this prefix
 * array after processing all the queries, and then we iterate through the array
 * and add the prefix calculated for that index with the element present at that
 * index.
 * 
 * So we try to solve this problem with a similar idea, here instead of adding
 * and subtracting the number we perform XOR operation and in our case, L will
 * be 0(considering 0-based indexing) and R will be equal to the size of the
 * current size of the array because here we have to perform XOR of the queried
 * integer with all the elements present in the array at the time of the query.
 * 
 * 
 * So we initialize an array(say XOR) of size Q+1( where Q is the number of
 * queries), and then as soon as we get any query of type 1 we add the value of
 * VAL to the array and if we get any query of type 2 then we will perform
 * XOR[0] = XOR[0]^VAL, and simultaneously XOR[current size of array] =
 * XOR[current size of array]^VAL.
 * 
 * After processing all the Q queries, we perform cumulative XOR operation, i.e
 * we iterate through the XOR array and perform XOR[i] = XOR[i]^XOR[i-1]. After
 * getting the cumulative XOR values perform the XOR operation between the array
 * element and the element present at the corresponding index in the XOR array,
 * i.e ARR[i] = ARR[i]^XOR[i]. And then print all the array elements.
 * 
 */
class Solution_Approach2 {

	public static ArrayList<Integer> xorQuery(ArrayList<ArrayList<Integer>> queries) {

		int n = queries.size();

		// Create an empty array ans
		ArrayList<Integer> ans = new ArrayList<Integer>();

		// Create an array xorArray of the size of 10^5+1 initialized with 0
		ArrayList<Integer> xorArray = new ArrayList<Integer>(n + 1);

		for (int i = 0; i < n + 1; i++) {
			xorArray.add(0);
		}

		// Iterate over all the queries
		for (int i = 0; i < queries.size(); i++) {

			if (queries.get(i).get(0) == 1) {
				ans.add(queries.get(i).get(1));
			} else {

				xorArray.set(0, (xorArray.get(0)) ^ (queries.get(i).get(1)));
				xorArray.set(ans.size(), (xorArray.get(ans.size())) ^ (queries.get(i).get(1)));

			}

		}

		// Computing cumulative prefix XOR and evaluating the answer
		for (int i = 0; i < ans.size(); i++) {

			if (i == 0) {
				ans.set(i, ans.get(i) ^ xorArray.get(i));
			} else {

				xorArray.set(i, (xorArray.get(i) ^ xorArray.get(i - 1)));
				ans.set(i, (ans.get(i) ^ xorArray.get(i)));
			}

		}

		return ans;

	}
}

/*
 * 
 * In this approach, we basically try to optimize the space using the property
 * of XOR that is �A(XOR)A� = 0 where A is an integer.
 * 
 * So here we maintain a variable named flag, initialized to 0.
 * 
 * 
 * Now we start processing queries, whenever we receive any query of type 1, we
 * XOR the queried value VAL with the current value of the flag variable and
 * insert that into the array. And when we receive any query of type 2 we modify
 * the value of the flag variable as flag = flag XOR (queried value VAL).
 * 
 * 
 * After processing all the queries we XOR all the values in the array with the
 * value of the variable flag obtained after processing all the queries. This is
 * because we have pushed the values XORed with the value that came before them
 * but we have to XOR them with the values that come after them. So, this
 * operation will nullify the effect of the previous XOR and the resultant will
 * be the desired value i.e the value after performing XOR operation with all
 * the type 2 query values that came after them.
 * 
 * 
 * After performing the above operation return the array values. For example: *
 * Let Q = 3, consider the following sequence of queries: 1 2, So we will add
 * 2^flag to the array since flag = 0, 2^flag will be equal to 2, and the array
 * now becomes{2}.
 * 
 * 
 * 2 3, Now we will update the value of the variable flag which was initially
 * set to 0, flag = flag^3, so flag becomes 3.
 * 
 * 
 * 
 * 1 1, Now we will add 1^flag to the array i.e 1^3= 2 to the array. So the
 * array becomes {2,2}.
 * 
 * 
 * 
 * Now all the queries have been processed, and after processing the value of
 * the flag is 3 so we will update all the elements of the array as ARR[i] =
 * ARR[i]^flag. So, the array becomes {2^3, 2^3} i.e {1,1}, which will be
 * returned as the final answer.
 * 
 * Time Complexity: O(Q) Space Complexity: O(1)
 * 
 * Where 'Q' is the number of queries
 */

class Solution {

	public static ArrayList<Integer> xorQuery(ArrayList<ArrayList<Integer>> queries) {

		// Create an empty array ans
		ArrayList<Integer> ans = new ArrayList<Integer>();

		// Create a variable flag
		int flag = 0;

		/*
		 * Iterate over the queries If the query is of type 1 then insert at the
		 * back of the array ans (queries[i][1] ^ Val) Otherwise, update the
		 * value of the flag as flag ^ queries[i][1]
		 */

		for (int i = 0; i < queries.size(); i++) {
			if (queries.get(i).get(0) == 1) {
				ans.add(queries.get(i).get(1) ^ flag);
			} else {
				flag ^= queries.get(i).get(1);
			}

		}

		// Iterate through the array ans and for each element in the array
		// update it as ans[i] = ans[i] ^ flag
		for (int i = 0; i < ans.size(); i++) {
			ans.set(i, ans.get(i) ^ flag);
		}

		// Return the array ans
		return ans;

	}
}
