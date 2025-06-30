package com.roadmap.binary_search.logic_building;

import java.util.ArrayList;

public class SearchInRotatedSortedArray2 {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int low = 0;
        int high = nums.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(mid) == k)
                return true;
            // Handling for arrays like [3,1,2,3,3,3,3]
            if (nums.get(low) == nums.get(mid) && nums.get(mid) == nums.get(high)) {
                low++;
                high--;
                continue;
            }
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) <= k && k <= nums.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums.get(mid) <= k && k <= nums.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
