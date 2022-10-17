package com.company.from201to300.problem242;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem242 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "anagram";
        String t = "nagaram";
        boolean answer = solution.isAnagram(s, t);
        System.out.println(answer);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            sList.add(s.charAt(i));
            tList.add(t.charAt(i));
        }
        sList = sList.stream().sorted().collect(Collectors.toList());
        tList = tList.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < sList.size(); i++){
            if (sList.get(i) != tList.get(i)){
                return false;
            }
        }

        return true;
    }
}
