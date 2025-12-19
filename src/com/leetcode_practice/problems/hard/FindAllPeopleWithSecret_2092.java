package com.leetcode_practice.problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindAllPeopleWithSecret_2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        boolean[] know = new boolean[n];
        know[0] = true;
        know[firstPerson] = true;
        // sorting the meetings by time
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[2]));
        int i = 0;

        while (i < meetings.length) {
            int t = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();
            while (i < meetings.length && meetings[i][2] == t) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
                people.add(x);
                people.add(y);
                i++;
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            for (int p : people) {
                if (know[p]) {
                    q.add(p);
                    visited.add(p);
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll();
                know[u] = true;
                for (int v : graph.getOrDefault(u, List.of())) {
                    if (visited.add(v)) {
                        q.add(v);
                    }
                }
            }

        }
        List<Integer> secrets = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (know[j]) {
                secrets.add(j);
            }
        }
        return secrets;
    }
}
