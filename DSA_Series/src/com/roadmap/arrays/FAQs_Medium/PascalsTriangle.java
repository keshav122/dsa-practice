package com.roadmap.arrays.FAQs_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> pascalLists = new ArrayList<>();
        if (numRows == 1) {
            pascalLists.add(Arrays.asList(1));
            return pascalLists;
        } else if (numRows == 2) {
            pascalLists.add(Arrays.asList(1));
            pascalLists.add(Arrays.asList(1, 1));
            return pascalLists;
        } else {
            pascalLists.add(Arrays.asList(1));
            pascalLists.add(Arrays.asList(1, 1));
            pascalListsForMoreThansTwoRows(pascalLists, numRows);
        }
        return pascalLists;
    }

    private void pascalListsForMoreThansTwoRows(List<List<Integer>> pascalLists, int numRows) {
        for (int i = 2; i < numRows; i++) {
            List<Integer> li = new ArrayList<>();
            // Adding 1 at the front of the list
            li.add(1);

            List<Integer> previousList = pascalLists.get(i - 1);
            // Managing the middle section of the list
            for (int j = 1; j < i; j++) {
                li.add(previousList.get(j - 1) + previousList.get(j));
            }

            // Adding 1 at the end of the list
            li.add(1);
            pascalLists.add(li);
        }
    }
}
