/*Author: keshav122 */
package com.roadmap.greedy_algorithms.scheduling_and_interval_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SchedulingMeetings {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        MeetingData[] meetingData = new MeetingData[n];
        for (int i = 0; i < n; i++) {
            meetingData[i] = new MeetingData(start[i], end[i], i);
        }

        Arrays.sort(meetingData, new Comparator<MeetingData>() {
            @Override
            public int compare(MeetingData o1, MeetingData o2) {
                return Integer.compare(o1.endTime, o2.endTime);
            }
        });

        int count = 1;
        int meetingEndTime = meetingData[0].endTime;
        List<Integer> positionArr = new ArrayList<>(meetingData[0].position);
        for (int i = 1; i < n; i++) {
            if (meetingData[i].startTime > meetingEndTime) {
                count++;
                positionArr.add(meetingData[i].position);
                meetingEndTime = meetingData[i].endTime;
            }
        }
        return count;
    }

}

class MeetingData {
    int startTime;
    int endTime;
    int position;

    public MeetingData(int startTime, int endTime, int position) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.position = position;
    }

}
