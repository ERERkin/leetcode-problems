package com.company.from101to200.problem125;

import java.util.ArrayList;
import java.util.List;

public class Problem125 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        boolean answer = solution.isPalindrome(s);
        System.out.println(answer);
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                characters.add(Character.toLowerCase(s.charAt(i)));
            }
        }
        for (int i = 0; i < characters.size() / 2; i++) {
            if (characters.get(i) != characters.get(characters.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
