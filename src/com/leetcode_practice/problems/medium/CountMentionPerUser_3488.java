package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMentionPerUser_3488 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        Map<Integer, Integer> userOnlineTimeMap = new HashMap<>();
        // all users are initially online
        for (int i = 0; i < numberOfUsers; i++) {
            userOnlineTimeMap.put(i, 0);
        }
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2)
                return t1 - t2;
            // At same timestamp: OFFLINE before MESSAGE
            boolean aOff = a.get(0).equals("OFFLINE");
            boolean bOff = b.get(0).equals("OFFLINE");
            return aOff == bOff ? 0 : (aOff ? -1 : 1);
        });

        for (List<String> event : events) {
            String eventType = event.get(0);
            int currTime = Integer.parseInt(event.get(1));
            String ids = event.get(2);
            if (eventType.equals("MESSAGE")) {
                if (ids.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (ids.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (userOnlineTimeMap.get(i) <= currTime) {
                            mentions[i]++;
                        }
                    }
                } else {
                    String[] users = ids.split(" ");
                    for (String user : users) {
                        int id = Integer.parseInt(user.substring(2));
                        mentions[id]++;
                    }
                }
            } else {
                int id = Integer.parseInt(ids);
                userOnlineTimeMap.put(id, currTime + 60);
            }
        }
        return mentions;
    }

    public int[] countMentions_Editorial(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });

        int[] count = new int[numberOfUsers];
        int[] nextOnlineTime = new int[numberOfUsers];

        for (List<String> event : events) {
            int curTime = Integer.parseInt(event.get(1));
            String type = event.get(0);

            if (type.equals("MESSAGE")) {
                String target = event.get(2);
                if (target.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        count[i]++;
                    }
                } else if (target.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (nextOnlineTime[i] <= curTime) {
                            count[i]++;
                        }
                    }
                } else {
                    String[] users = target.split(" ");
                    for (String user : users) {
                        int idx = Integer.parseInt(user.substring(2));
                        count[idx]++;
                    }
                }
            } else {
                int idx = Integer.parseInt(event.get(2));
                nextOnlineTime[idx] = curTime + 60;
            }
        }

        return count;
    }
}
