package com.company.from1to100.problem3;

import java.util.HashMap;
import java.util.HashSet;

public class Problem3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "dvdf";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int answer = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            int index = !hashMap.containsKey(character) ? i : hashMap.get(character) + 1;
            int size = hashMap.size();
            hashMap.put(character, i);
            if (size != hashMap.size()) {
                current++;
                answer = Math.max(answer, current);
            } else {
                current = 1;
                hashMap = new HashMap<>();
                i = index;
                hashMap.put(s.charAt(index), index);
            }
        }
        return answer;
    }
}