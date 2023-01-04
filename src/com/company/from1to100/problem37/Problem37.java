package com.company.from1to100.problem37;

import java.util.ArrayList;
import java.util.List;

public class Problem37 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("" + board[i][j] + " ");
            }
            System.out.println();
        }
        solution.solveSudoku(board);
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("" + board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    List<Character> numbers = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        fillAllNumbers();
        fill(board, 0, 0);
    }

    private void fillAllNumbers() {
        for (int i = 0; i < 9; i++) {
            numbers.add((char) ('1' + i));
        }
    }

    private boolean fill(char[][] board, int h, int w) {
        if (h == 9) {
            return true;
        }
        if (w == 9) {
            return fill(board, h + 1, 0);
        }
        if (board[h][w] != '.') {
            return fill(board, h, w + 1);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (check(board, h, w, numbers.get(i))) {
                board[h][w] = numbers.get(i);
                if (fill(board, h, w + 1)) {
                    return true;
                }
                board[h][w] = '.';
            }
        }
        return false;
    }

    private boolean check(char[][] board, int h, int w, char character) {
        int hh = h / 3;
        int ww = w / 3;
        for (int i = hh * 3; i < (hh + 1) * 3; i++) {
            for (int j = ww * 3; j < (ww + 1) * 3; j++) {
                if (board[i][j] == character) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[h][i] == character) {
                return false;
            }
            if (board[i][w] == character) {
                return false;
            }
        }
        return true;
    }
}