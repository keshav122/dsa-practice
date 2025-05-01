package com.roadmap.binary_search.FAQs;

import java.util.PriorityQueue;

public class MinimizeMaxDistToGasStations {

    public static class Pair {
        double sectionLength;
        int sectionIndex;

        public Pair(double sectionLength, int sectionIndex) {
            super();
            this.sectionLength = sectionLength;
            this.sectionIndex = sectionIndex;
        }

        public double getSectionLength() {
            return sectionLength;
        }

        public void setSectionLength(double sectionLength) {
            this.sectionLength = sectionLength;
        }

        public int getSectionIndex() {
            return sectionIndex;
        }

        public void setSectionIndex(int sectionIndex) {
            this.sectionIndex = sectionIndex;
        }

    }

    public double minimiseMaxDistance_BF(int[] arr, int k) {
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

    public double minimiseMaxDistance_PriorityQueueApproach(int[] arr, int k) {
        int n = arr.length;
        int[] howManyPlaced = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(((a, b) -> Double.compare(b.sectionLength, a.sectionLength)));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        for (int gasStation = 1; gasStation <= k; gasStation++) {
            Pair topelement = pq.poll();
            int sectionIndex = topelement.sectionIndex;
            howManyPlaced[sectionIndex]++;
            double initialSecDiff = arr[sectionIndex + 1] - arr[sectionIndex];
            double newSectionLength = initialSecDiff / (double) (howManyPlaced[sectionIndex] + 1);
            pq.add(new Pair(newSectionLength, sectionIndex));
        }
        return pq.peek().sectionLength;
    }

    public double minimiseMaxDistance_MostOptimalBinarySearchSolution(int[] arr, int k) {
        double low = 0;
        double high = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int count = getNumberOfGasStations(arr, mid);
            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private int getNumberOfGasStations(int[] arr, double mid) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int gasStationPlaced = (int) (((arr[i] - arr[i - 1])) / mid);
            if ((arr[i] - arr[i - 1]) * gasStationPlaced == mid * gasStationPlaced) {
                gasStationPlaced--;
            }
            count += gasStationPlaced;
        }
        return count;
    }

}
