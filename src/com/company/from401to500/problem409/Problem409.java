package com.company.from401to500.problem409;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem409 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "A man, a plan, a canal: Panama";
//        String s = "A man, a plan, a canal: Panama";
        String s = "bananas";
        int answer = solution.longestPalindrome(s);
        System.out.println(answer);
    }
}

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), 1);
                continue;
            }
            hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Integer> item : hashMap.entrySet()) {
            list.add(item.getValue());
        }
        list = list.stream().sorted().collect(Collectors.toList());
        boolean isAlreadyHasOddNum = false;
        for (int i = list.size() - 1; i >= 0; i--){
            if (list.get(i) % 2 == 1 && !isAlreadyHasOddNum) {
                answer += list.get(i);
                isAlreadyHasOddNum = true;
            } else if (list.get(i) % 2 == 0) {
                answer += list.get(i);
            } else {
                answer += list.get(i) - 1;
            }
        }
        return answer;
    }
}