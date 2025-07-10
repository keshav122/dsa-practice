package com.dsa_series.roadmap.binary_search.contests;

public class CleaningWindows {
    public int cleaningWindows(int[] windows, int h) {
        int n = windows.length;
        if (h < n)
            return -1;
        int low = 1;// atleast clean 1 window per hour
        int high = 0;
        for (int window : windows) {
            high += window;
        }

        while (low <= high) {
            int mid = (low + high) >> 1;
            int hoursReq = getHours(windows, mid);
            if (hoursReq > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int getHours(int[] windows, int cleaningRate) {
        int hours = 0;
        for (int window : windows) {
            hours += (window + cleaningRate - 1) / cleaningRate;
        }
        return hours;
    }
}
