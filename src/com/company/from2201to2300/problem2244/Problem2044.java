package com.company.from2201to2300.problem2244;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2044 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tasks = new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(solution.minimumRounds(tasks));
    }
}

class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        List<Integer> levels = new ArrayList<>();
        int prev = tasks[0];
        int count = 1;
        for (int i = 1; i < tasks.length; i++) {
            if (prev == tasks[i]) {
                count++;
            } else {
                levels.add(count);
                prev = tasks[i];
                count = 1;
            }
        }
        levels.add(count);
        int answer = 0;
        for (Integer level : levels) {
            int rounds = process(level);
            if (rounds == -1) {
                return -1;
            }
            answer += rounds;
        }
        return answer;
    }

    public int process(int tasks) {
        int count3 = 0;
        int count2 = 0;
        if (tasks % 3 == 1) {
            count3 = tasks / 3 - 1;
            count2 = (tasks - count3 * 3) / 2;
        } else if (tasks % 3 == 2) {
            count3 = tasks / 3;
            count2 = 1;
        } else {
            count3 = tasks / 3;
        }
        if (tasks < 2) return -1;
        return count2 + count3;
    }
}
