package com.roadmap.binary_search.FAQs;

public class MinimizeMaxDistToGasStations {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howManyPlaced = new int[n - 1];
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            double maxSection = -1;
            int maxInd = -1;
            for (int i = 0; i < n - 1; i++) {
                double difference = arr[i + 1] - arr[i];
                double sectionLength = difference / (double) (howManyPlaced[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            howManyPlaced[maxInd]++;
        }
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double sectionLength = (arr[i + 1] - arr[i]) / (double) (howManyPlaced[i] + 1);
            maxAns = Math.max(sectionLength, maxAns);
        }
        return maxAns;
    }
}
