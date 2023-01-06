package com.company.from1801to1900.problem1833;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1833 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxIceCream(new int[] {1,3,2,4,1}, 7));
    }
}

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int answer = 0;
        Arrays.sort(costs);

        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                answer++;
                coins -= costs[i];
            } else {
                break;
            }
        }

        return answer;
    }
}
