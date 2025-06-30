package com.dsa_series.roadmap.binary_search.logic_building;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Its basically is finding the min value .. because the min value is 
//the first index and whereever that is placed we can calculate the shift from there

public class FindOutHowManyTimesArrayIsRotated {
    public int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        int minValue = Integer.MAX_VALUE;
        int minIndex = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(mid) < minValue) {
                minValue = nums.get(mid);
                minIndex = mid;
            }
            // left half is sorted
            else if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < minValue) {
                    minValue = nums.get(low);
                    minIndex = low;
                }
                low = mid + 1;
            } else {
                if (nums.get(mid) <= nums.get(high)) {
                    minValue = nums.get(mid);
                    minIndex = mid;
                }
                high = mid - 1;
            }
        }
        return minIndex + 1;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3);
        ArrayList<Integer> input = new ArrayList<>();
        input.addAll(li);
        FindOutHowManyTimesArrayIsRotated f = new FindOutHowManyTimesArrayIsRotated();
        System.out.println(f.findKRotation(input));
    }
}
