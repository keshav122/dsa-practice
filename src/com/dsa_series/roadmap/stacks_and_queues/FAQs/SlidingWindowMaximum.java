/*Author: keshav122 */
package com.dsa_series.roadmap.stacks_and_queues.FAQs;

import java.util.LinkedList;

import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow_BF(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(arr[j], max);
            }
            ans[i] = max;
        }
        return ans;
    }

    public int[] maxSlidingWindow_Better(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i< n ;i++){   
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }  
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k-1){
              ans[ansIndex] = arr[dq.peekFirst()];
              ansIndex++;
            }
        }
        return ans;
    }
}
