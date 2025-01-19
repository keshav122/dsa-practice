package com.roadmap.recursion.FAQs_Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> possibleBoards = new ArrayList<>();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += ".";
        }
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(s);
        }
        generateBoardSets(0, possibleBoards, board, n);
        return possibleBoards;
    }

    private void generateBoardSets(int row, List<List<String>> possibleBoards, List<String> board, int n) {
        if (row == n) {
            possibleBoards.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isPlacingQueenPossible(row, col, board, n)) {
                String temp = board.get(row);
                String newString = temp.substring(0, col) + "Q" + temp.substring(col + 1, n);
                board.set(row, newString);
                generateBoardSets(row + 1, possibleBoards, board, n);
                board.set(row, temp);
            }
        }
    }

    private boolean isPlacingQueenPossible(int row, int col, List<String> board, int n) {
        int r = row, c = col;
        // Checking if the queen exists in the top
        while (r >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
        }

        r = row;
        c = col;
        // right diagonal check
        while (r >= 0 && c < n) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        r = row;
        c = col;
        // left diagonal check
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        return true;
    }
}
