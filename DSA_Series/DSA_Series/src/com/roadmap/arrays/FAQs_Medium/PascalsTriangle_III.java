package com.roadmap.arrays.FAQs_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_III {
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

    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(rowOfPascalTriangle(i));
        }
        return res;
    }

    private List<Integer> rowOfPascalTriangle(int r) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i < r; i++) {
            int val = (ans.get(i - 1) * (r - i));
            val /= i;
            ans.add(val);
        }
        return ans;
    }
}
