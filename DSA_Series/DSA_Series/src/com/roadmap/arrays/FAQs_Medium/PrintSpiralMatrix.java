package com.roadmap.arrays.FAQs_Medium;

import java.util.LinkedList;
import java.util.List;

public class PrintSpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new LinkedList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, top = 0, right = cols - 1, bottom = rows - 1;
        while (true) {
            // print Left to Right
            for (int i = left; i <= right; i++) {
                spiralList.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            // print Up to Down
            for (int i = top; i <= bottom; i++) {
                spiralList.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            // print Right to Left
            for (int i = right; i >= left; i--) {
                spiralList.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) {
                break;
            }

            // print Down to Up
            for (int i = bottom; i >= top; i--) {
                spiralList.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return spiralList;
    }

    public static void main(String[] args) {
        int[][] input = { { 1, 4, 5 } };
        PrintSpiralMatrix p = new PrintSpiralMatrix();
        List<Integer> res = p.spiralOrder(input);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
