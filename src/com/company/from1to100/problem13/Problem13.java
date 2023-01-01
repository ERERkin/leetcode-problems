package com.company.from1to100.problem13;

public class Problem13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.romanToInt("MMMCMXCIX");
        System.out.println(a);
    }
}

class Solution {
    public String num = "";

    public int romanToInt(String s) {
        String nums10[] = new String[]{"I", "X", "C", "M"};
        String nums5[] = new String[]{"V", "L", "D"};
        int iStart = 2;
        num = s;
        int answer = 0;
        if (s.charAt(0) == 'M') {
            num = s.substring(1);
            answer = 1000;
        }
        if (s.length() > 1 && s.substring(0, 2).equals("MM")) {
            num = s.substring(2);
            answer = 2000;
        }
        if (s.length() > 2 && s.substring(0, 3).equals("MMM")) {
            num = s.substring(3);
            answer = 3000;
        }
        for (int i = iStart; i >= 0; i--) {
            answer += convert(nums10[i], nums5[i], nums10[i + 1]) * ((int) Math.pow(10, i));
        }
        return answer;
    }

    public int convert(String currentTen, String current5, String next10) {
        String nums[] = new String[]{
                currentTen,
                currentTen + currentTen,
                currentTen + currentTen + currentTen,
                currentTen + current5,
                current5,
                current5 + currentTen,
                current5 + currentTen + currentTen,
                current5 + currentTen + currentTen + currentTen,
                currentTen + next10
        };

        if (num.startsWith(nums[8])) {
            if (num.length() > nums[8].length()) num = num.substring(nums[8].length());
            return 9;
        } else if (num.startsWith(nums[7])) {
            if (num.length() > nums[7].length()) num = num.substring(nums[7].length());
            return 8;
        } else if (num.startsWith(nums[6])) {
            if (num.length() > nums[6].length()) num = num.substring(nums[6].length());
            return 7;
        } else if (num.startsWith(nums[5])) {
            if (num.length() > nums[5].length()) num = num.substring(nums[5].length());
            return 6;
        } else if (num.startsWith(nums[4])) {
            if (num.length() > nums[4].length()) num = num.substring(nums[4].length());
            return 5;
        } else if (num.startsWith(nums[3])) {
            if (num.length() > nums[3].length()) num = num.substring(nums[3].length());
            return 4;
        } else if (num.startsWith(nums[2])) {
            if (num.length() > nums[2].length()) num = num.substring(nums[2].length());
            return 3;
        } else if (num.startsWith(nums[1])) {
            if (num.length() > nums[1].length()) num = num.substring(nums[1].length());
            return 2;
        } else if (num.startsWith(nums[0])) {
            if (num.length() > nums[0].length()) num = num.substring(nums[0].length());
            return 1;
        }
        return 0;
    }
}
