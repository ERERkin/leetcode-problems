package com.company.from401to500.problem413;

import java.util.ArrayList;
import java.util.List;

public class Problem413 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 10, 7, 8, 9, 10, 11, 12};
        int answer = solution.numberOfArithmeticSlices(nums);
        System.out.println(answer);
    }
}

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int arithmeticProgression;
        if (nums.length < 3) return 0;
        int difference = nums[0] - nums[1];
        int progressionCurrentCount = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] - nums[i + 1] == difference) {
                progressionCurrentCount++;
            } else {
                if (progressionCurrentCount >= 2) {
                    list.add(progressionCurrentCount + 1);
                }
                difference = nums[i] - nums[i + 1];
                progressionCurrentCount = 1;
            }
        }
        if (progressionCurrentCount >= 2) {
            list.add(progressionCurrentCount + 1);
        }
        arithmeticProgression = list.stream().map(progressionCount -> getArithmeticSum(progressionCount)).reduce(0, Integer::sum);
        return arithmeticProgression;
    }

    private int getArithmeticSum(int count) {
        count -= 2;
        return count * (1 + count) / 2;
    }
}
