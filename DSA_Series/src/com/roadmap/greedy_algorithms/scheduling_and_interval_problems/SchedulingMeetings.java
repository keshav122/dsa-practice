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
            meetingData[i].setStartTime(start[i]);
            meetingData[i].setEndTime(end[i]);
            meetingData[i].setPosition(i);
        }
        Arrays.sort(meetingData, new Comparator<MeetingData>() {
            @Override
            public int compare(MeetingData o1, MeetingData o2) {
                return Integer.compare(o1.getEndTime(), o2.getEndTime());
            }

        });

        int count = 1;
        int meetingEndTime = meetingData[0].getEndTime();
        List<Integer> positionArr = new ArrayList<>(meetingData[0].getPosition());
        for (int i = 1; i < n; i++) {
            if (meetingData[i].getStartTime() > meetingEndTime) {
                count++;
                positionArr.add(meetingData[i].getPosition());
                meetingEndTime = meetingData[i].getEndTime();
            }
        }
        return count;

    }
}

class MeetingData {
    private int startTime;
    private int endTime;
    private int position;

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setPosition(int position) {
        this.position = startTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getPosition() {
        return this.position;
    }
}
