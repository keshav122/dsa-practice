package com.dsa_series.roadmap.recursion.FAQs_Hard;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (wordExists(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean wordExists(char[][] board, String word, int rowIndex, int colIndex, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;

        if (board[rowIndex][colIndex] == ' ' || board[rowIndex][colIndex] != word.charAt(wordIndex)) {
            return false;
        } else {
            board[rowIndex][colIndex] = ' ';
            boolean ans = false;
            // check if top is possible and successive
            if (rowIndex > 0) {
                ans |= wordExists(board, word, rowIndex - 1, colIndex, ++wordIndex);
            }
            // check if left is possible and successive
            if (colIndex > 0) {
                ans |= wordExists(board, word, rowIndex, colIndex - 1, ++wordIndex);
            }

            // check if bottom is possible and successive
            if (rowIndex < row - 1) {
                ans |= wordExists(board, word, rowIndex + 1, colIndex, ++wordIndex);
            }

            // check if right is possible and successive
            if (colIndex < col - 1) {
                ans |= wordExists(board, word, rowIndex, colIndex + 1, ++wordIndex);
            }
            return ans;
        }
    }
}
