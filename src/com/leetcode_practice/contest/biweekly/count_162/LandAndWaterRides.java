package com.leetcode_practice.contest.biweekly.count_162;

public class LandAndWaterRides {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minLandFinishTime = Integer.MAX_VALUE;
        int minLandFinishIndex = 0;
        int minWaterFinishTime = Integer.MAX_VALUE;
        int minWaterFinishIndex = 0;
        int[] earLiestFinishLandTime = new int[n];
        int[] earLiestFinishWaterTime = new int[m];
        for (int i = 0; i < n; i++) {
            earLiestFinishLandTime[i] = landStartTime[i] + landDuration[i];
            if (earLiestFinishLandTime[i] < minLandFinishTime) {
                minLandFinishTime = earLiestFinishLandTime[i];
                minLandFinishIndex = i;
            }

        }

        for (int i = 0; i < m; i++) {
            earLiestFinishWaterTime[i] = waterStartTime[i] + waterDuration[i];
            if (earLiestFinishWaterTime[i] < minWaterFinishTime) {
                minWaterFinishTime = earLiestFinishWaterTime[i];
                minWaterFinishIndex = i;
            }
        }

        int totalTime = 0;
        if (landStartTime[minLandFinishIndex] <= waterStartTime[minWaterFinishIndex]) {
            totalTime += earLiestFinishLandTime[minLandFinishIndex];
            if (waterStartTime[minWaterFinishIndex] >= earLiestFinishLandTime[minLandFinishIndex]) {
                return earLiestFinishWaterTime[minWaterFinishIndex];
            }
            totalTime += waterDuration[minWaterFinishIndex];
            return totalTime;
        } else {
            totalTime += earLiestFinishWaterTime[minWaterFinishIndex];
            if (landStartTime[minLandFinishIndex] >= earLiestFinishWaterTime[minWaterFinishIndex]) {
                return earLiestFinishLandTime[minLandFinishIndex];
            }
            totalTime += landDuration[minLandFinishIndex];
            return totalTime;
        }
    }

    public int earliestFinishTime_Correcr(int[] landStartTime, int[] landDuration, int[] waterStartTime,
            int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                // land first, water later
                int startLand = landStartTime[i];
                int endLand = startLand + landDuration[i];
                int startWater = Math.max(endLand, waterStartTime[j]);
                int finish1 = startWater + waterDuration[j];

                // water first, land later
                int startWaterFirst = waterStartTime[j];
                int endWaterFirst = startWaterFirst + waterDuration[j];
                int startLandLater = Math.max(endWaterFirst, landStartTime[i]);
                int finish2 = startLandLater + landDuration[i];

                minFinishTime = Math.min(minFinishTime, Math.min(finish1, finish2));
            }
        }
        return minFinishTime;
    }

    public static void main(String[] args) {
        int[] landStartTime = { 5 };
        int[] landDuration = { 3 };
        int[] waterStartTime = { 1 };
        int[] waterDuration = { 10 };
        LandAndWaterRides l = new LandAndWaterRides();
        System.out.println(l.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));

    }
}
