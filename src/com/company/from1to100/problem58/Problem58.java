package com.company.from1to100.problem58;

public class Problem58 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Test run       ";
        int answer = solution.lengthOfLastWord(s);
        System.out.println(answer);
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        boolean isSpace;
        boolean isLastWordFound = false;
        int lastWordLength = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            isSpace = s.charAt(i) == ' ';
            if (isSpace && isLastWordFound) {
                break;
            }
            if (!isSpace) {
                isLastWordFound = true;
            }
            if (isLastWordFound){
                lastWordLength++;
            }
        }

        return lastWordLength;
    }
}