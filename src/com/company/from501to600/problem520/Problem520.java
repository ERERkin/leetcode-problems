package com.company.from501to600.problem520;

public class Problem520 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("Google"));
    }
}

class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        if (count == word.length()) {
            return true;
        }
        if (count == 0) {
            return true;
        }
        if (count == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }
}
