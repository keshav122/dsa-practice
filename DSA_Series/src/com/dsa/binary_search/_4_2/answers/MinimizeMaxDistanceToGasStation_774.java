package com.dsa.binary_search._4_2.answers;

import java.util.PriorityQueue;

/**
 * 
 * On a horizontal number line, we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1], where N = stations.length. Now, we add K
 * more gas stations so that D, the maximum distance between adjacent gas
 * stations, is minimized. Return the smallest possible value of D.
 * 
 * 1.stations.length will be an integer in range [10, 2000]. 2.stations[i] will
 * be an integer in range [0, 10^8]. 3.K will be an integer in range [1, 10^6].
 * 4.Answers within 10^-6 of the true value will be accepted as correct.
 * 
 * IP 1 : Input：stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]，K = 9 Output：0.50
 * Explanation：The distance between adjacent gas stations is 0.50
 * 
 * IP 2: Input：stations = [3,6,12,19,33,44,67,72,89,95]，K = 2 Output：14.00
 * Explanation：construction of gas stations at 86 locations
 */

public class MinimizeMaxDistanceToGasStation_774 {

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

	public static double minmaxGasDist(int[] stations, int k) {
		int n = stations.length;
		// This array will keep track of how many gas stations are placed in each
		// section. A section refers to the space between the two gas stations.
		int[] howMany = new int[n - 1];
		for (int gasStation = 1; gasStation <= k; gasStation++) {
			double maxValue = -1;
			int maxSectionIndex = -1;
			for (int i = 0; i < n - 1; i++) {
				int diff = stations[i + 1] - stations[i];
				// The section length will be calculated by dividing the distance divided by the
				// number of gasStation in between + 1.
				double sectionLen = diff / (howMany[i] + 1);
				if (sectionLen > maxValue) {
					maxValue = sectionLen;
					maxSectionIndex = i;
				}
			}
			howMany[maxSectionIndex]++;
		}

		double maxAns = -1;
		for (int i = 0; i < n - 1; i++) {
			double sectionLength = (stations[i + 1] - stations[i]) / (double) ((howMany[i] + 1));
			maxAns = Math.max(maxAns, sectionLength);
		}
		return maxAns;
	}

	public static double minmaxGasDist_PriorityQueueSolution(int[] stations, int k) {
		int n = stations.length;
		// This array will keep track of how many gas stations are placed in each
		// section. A section refers to the space between the two gas stations.
		int[] howMany = new int[n - 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>(((a, b) -> Double.compare(b.sectionLength, a.sectionLength)));
		for (int i = 0; i < n - 1; i++) {
			pq.add(new Pair(stations[i + 1] - stations[i], i));
		}
		for (int gasStation = 1; gasStation <= k; gasStation++) {
			Pair topElement = pq.peek();
			pq.remove();
			int sectionIndex = topElement.getSectionIndex();
			howMany[sectionIndex]++;
			double initialSecDiff = stations[sectionIndex + 1] - stations[sectionIndex];
			double newSectionLength = initialSecDiff / (double) (howMany[sectionIndex] + 1);
			pq.add(new Pair(newSectionLength, sectionIndex));

		}
		return pq.peek().getSectionLength();
	}

	public static double minmaxGasDist_MostOptimalSolution(int[] stations, int k) {
		double low = 0;
		double high = 0;
		int n = stations.length;
		for (int i = 0; i < n - 1; i++) {
			high = Math.max(stations[i + 1] - stations[i], high);
		}

		while (high - low > (1 / (double) Math.pow(10, 6))) {
			double mid = (low + high) / 2.0;
			// count of Gas stations required to maintain this mid distance
			int count = countOfGasStationsReq(stations, mid, n);
			if (count > k)
				low = mid;
			else {
				high = mid;
			}
		}
		return high;
	}

	static int countOfGasStationsReq(int[] stations, double midDist, int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			int noInBetween = (int) ((stations[i] - stations[i - 1]) / midDist);
			// If the difference in sections is absolutely divisble we can place one
			// lesser gas station
			if (stations[i] - stations[i - 1] / midDist == noInBetween * midDist) {
				noInBetween--;
			}
			count += noInBetween;
		}

		return count;
	}

	public static void main(String[] args) {
		int[] stations1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] stations2 = { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 };

		int k1 = 9;
		int k2 = 2;
		System.out.println(minmaxGasDist_MostOptimalSolution(stations1, k1));
		System.out.println(minmaxGasDist_MostOptimalSolution(stations2, k2));
	}
}
