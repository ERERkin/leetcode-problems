package com.company.from1to100.problem5;

public class Problem5 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a";
        String answer = solution.longestPalindrome(s);
        System.out.println(answer);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String biggestPalindromicSubstring = "";
        for (int i = 0; i < s.length() - 1; i++){
            String currentOddPalindromicSubString = palindromicSubstring(s, i, true);
            String currentEvenPalindromicSubString = palindromicSubstring(s, i, false);
            if (currentOddPalindromicSubString.length() > biggestPalindromicSubstring.length()){
                biggestPalindromicSubstring = currentOddPalindromicSubString;
            }
            if (currentEvenPalindromicSubString.length() > biggestPalindromicSubstring.length()){
                biggestPalindromicSubstring = currentEvenPalindromicSubString;
            }
        }
        return biggestPalindromicSubstring;
    }

    private String palindromicSubstring(String s, int currentIndex, Boolean isOddNum){
        int leftIndex = currentIndex;
        int rightIndex = isOddNum ? currentIndex : currentIndex + 1;
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)){
            leftIndex--;
            rightIndex++;
        }
        String subString = "";
        for (int i = leftIndex + 1; i < rightIndex; i++){
            subString += s.charAt(i);
        }
        return subString;
    }
}