package com.company.from1to100.problem8;

public class Problem8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("1"));
    }
}

class Solution {
    public int myAtoi(String s) {
        StringBuilder nums = new StringBuilder("");
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (isNumeric("" + s.charAt(i))) {
                nums.append(s.charAt(i));
            } else if (s.charAt(i) == '-' && s.length() - 1 > i && isNumeric("" + s.charAt(i + 1))) {
                if (i > 0 && isNumeric("" + s.charAt(i - 1))) {
                    break;
                }
                nums.append(s.charAt(i));
            } else if (s.charAt(i) == '+' && s.length() - 1 > i && isNumeric("" + s.charAt(i + 1))) {
                if (i > 0 && isNumeric("" + s.charAt(i - 1))) {
                    break;
                }
            } else if (s.charAt(i) != ' ') {
                break;
            } else if (s.charAt(i) == ' ') {
                if (i > 0 && isNumeric("" + s.charAt(i - 1))) {
                    break;
                }
            }
        }
        if (nums.length() == 0) return 0;
        long longAnswer = 0;
        try {
            longAnswer = Long.parseLong(nums.toString());
            if (longAnswer > Math.pow(2, 31) - 1) {
                longAnswer = (long) Math.pow(2, 31) - 1;
            } else if (longAnswer < -1 * Math.pow(2, 31)) {
                longAnswer = (long) Math.pow(2, 31);
            }
        } catch (NumberFormatException e) {
            if (nums.charAt(0) == '-') {
                longAnswer = (long) Math.pow(2, 31);
            } else {
                longAnswer = (long) Math.pow(2, 31) - 1;
            }
        }
        return (int) longAnswer;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
