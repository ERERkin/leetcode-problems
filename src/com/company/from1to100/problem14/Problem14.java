package com.company.from1to100.problem14;

import java.util.Arrays;

public class Problem14 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"flower", "flow", "flight"};
        String answer = solution.longestCommonPrefix(strings);
        System.out.println(answer);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minSize = Arrays.stream(strs)
                .map(s -> s.length())
                .min(Integer::compare)
                .get();

        StringBuilder answer = new StringBuilder();
        for (int si = 0; si < minSize; si++) {
            char letter = strs[0].charAt(si);
            int count = 1;
            for (int i = 1; i < strs.length; i++) {
                if (letter == strs[i].charAt(si)) {
                    count++;
                }
            }
            if (count == strs.length){
                answer.append(letter);
            }else {
                break;
            }
        }
        return answer.toString();
    }
}
