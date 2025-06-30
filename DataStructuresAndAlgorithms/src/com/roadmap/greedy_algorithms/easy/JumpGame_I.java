/*Author: keshav122 */
package com.roadmap.greedy_algorithms.easy;

public class JumpGame_I {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndexReached = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxIndexReached) {
                return false;
            } else {
                maxIndexReached = Math.max(i + nums[i], maxIndexReached);
            }
        }
        return true;
    }
}
