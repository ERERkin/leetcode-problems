package com.company.from201to300.problem290;

import java.util.*;
import java.util.stream.Collectors;

public class Problem290 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(solution.wordPattern(pattern, s));
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        List<String> list = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        HashMap<Character, String> hashMap = new HashMap<>();
        if (pattern.length() != list.size()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            Character character = pattern.charAt(i);
            String string = list.get(i);
            if (hashMap.containsKey(character)) {
                if (!hashMap.get(character).equals(string)) {
                    return false;
                }
            }
            hashMap.put(character, string);
        }
        HashSet<String> hashSet = new HashSet<>();
        for (Map.Entry<Character, String> item: hashMap.entrySet()) {
            hashSet.add(item.getValue());
        }
        return hashMap.size() == hashSet.size();
    }
}
