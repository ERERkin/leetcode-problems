package com.company.from1to100.problem12;

public class Problem12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 5;
        System.out.println(solution.intToRoman(num));
    }
}

class Solution {
    public String intToRoman(int num) {
        String nums10[] = new String[]{"I", "X", "C", "M", ""};
        String nums5[] = new String[]{"V", "L", "D", "", ""};
        String answer = "";
        int j = 0;
        while (num > 0) {
            int one = num % 10;
            answer = convert(one, nums10[j], nums5[j], nums10[j + 1]) + answer;
            num = num / 10;
            j++;
        }
        return answer;
    }

    public String convert(int num, String currentTen, String current5, String next10) {
        if (num == 1) {
            return currentTen;
        } else if (num == 2) {
            return currentTen + currentTen;
        } else if (num == 3) {
            return currentTen + currentTen + currentTen;
        } else if (num == 4) {
            return currentTen + current5;
        } else if (num == 5) {
            return current5;
        } else if (num == 6) {
            return current5 + currentTen;
        } else if (num == 7) {
            return current5 + currentTen + currentTen;
        } else if (num == 8) {
            return current5 + currentTen + currentTen + currentTen;
        } else if (num == 9) {
            return currentTen + next10;
        }
        return "";
    }
}
