package com.company.from901to1000.problem944;

import java.util.Arrays;

public class Problem944 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDeletionSize(new String[] {"cba","daf","ghi"}));
    }
}

class Solution {
    public int minDeletionSize(String[] strs) {
        int answer = 0;
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
