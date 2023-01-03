package com.company.from1to100.problem52;

import java.util.ArrayList;
import java.util.List;

public class Problem52 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}

class Solution {
    int answer = 0;

    public int totalNQueens(int n) {
        List<Character[]> chessboard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Character[] characters = new Character[n];
            for (int j = 0; j < n; j++) {
                characters[j] = '.';
            }
            chessboard.add(characters);
        }
        find(chessboard, 0);
        return answer;
    }

    public void find(List<Character[]> chessboard, int num) {
        if (chessboard.size() == num) {
            answer++;
            return;
        }
        for (int i = 0; i < chessboard.size(); i++) {
            if (isSafe(chessboard, num, i)) {
                chessboard.get(num)[i] = 'Q';
                find(chessboard, num + 1);
                chessboard.get(num)[i] = '.';
            }
        }
    }

    public boolean isSafe(List<Character[]> chessboard, int num, int letter) {
        for (int i = 0; i < num; i++) {
            if (chessboard.get(i)[letter] == 'Q') {
                return false;
            }
        }
        for (int i = num, j = letter; i >= 0 && j >= 0; i--, j--) {
            if (chessboard.get(i)[j] == 'Q') {
                return false;
            }
        }
        for (int i = num, j = letter; i >= 0 && j < chessboard.size(); i--, j++) {
            if (chessboard.get(i)[j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
