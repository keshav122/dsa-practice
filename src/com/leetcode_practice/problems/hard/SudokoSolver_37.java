package com.leetcode_practice.problems.hard;

public class SudokoSolver_37 {
    public void solveSudoku(char[][] board) {
        updateSudokuBoard(board);
    }

    private boolean updateSudokuBoard(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (areRulesFollowed(board, i, j, c)) {
                            board[i][j] = c;
                            if (updateSudokuBoard(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areRulesFollowed(char[][] board, int row, int col, char c) {
        int nRow = (row / 3) * 3, nCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            // row and col level check
            if (board[row][i] == c || board[i][col] == c) {
                return false;
            }
            // matrix level check
            if (board[nRow + (i / 3)][nCol + (i % 3)] == c) {
                return false;
            }
        }
        return true;
    }
}
