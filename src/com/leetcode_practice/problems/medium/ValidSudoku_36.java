package com.leetcode_practice.problems.medium;

public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col) {
        char currentChar = board[row][col];
        board[row][col] = '.';
        int nRow = (row / 3) * 3, nCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            // row check
            if (board[row][i] == currentChar) {
                return false;
            }
            // col Check
            if (board[i][col] == currentChar) {
                return false;
            }

            // matrix level check
            if (board[nRow + (i / 3)][nCol + (i % 3)] == currentChar) {
                return false;
            }
        }
        return true;
    }
}
