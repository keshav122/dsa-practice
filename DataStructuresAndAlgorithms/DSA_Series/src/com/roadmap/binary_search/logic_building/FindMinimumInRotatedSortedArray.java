package com.roadmap.binary_search.logic_building;

import java.util.ArrayList;

public class FindMinimumInRotatedSortedArray {
    public int findMin(ArrayList<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) < min) {
                min = arr.get(mid);
            } else if (arr.get(low) <= arr.get(mid)) {
                min = Math.min(min, arr.get(low));
                low = mid + 1;
            } else {
                min = Math.min(min, arr.get(mid));
                high = mid - 1;
            }
        }
        return min;
    }
}
