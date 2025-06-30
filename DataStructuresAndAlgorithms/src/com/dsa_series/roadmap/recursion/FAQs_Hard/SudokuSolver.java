/*Author: keshav122 */
package com.roadmap.recursion.FAQs_Hard;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        updateSudokuBoard(board);
    }

    private boolean updateSudokuBoard(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (areRulesFollowed(digit, i, j, board)) {
                            board[i][j] = digit;
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

    private boolean areRulesFollowed(char digit, int row, int col, char[][] board) {
        int startRow = (row / 3) * 3, startCol = (col / 3) * 3;
        for (int i = 0; i <= 8; i++) {
            // if present in row or col
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
            if (board[startRow + (i / 3)][startCol + (i % 3)] == digit) {
                return false;
            }
        }
        return true;
    }
}
