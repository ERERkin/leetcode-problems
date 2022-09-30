package com.company.from1001to11000.problem1005;

import java.util.Arrays;

public class Problem1005 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,-3,-1,5,-4};
        int k = 2;
        int answer = solution.largestSumAfterKNegations(nums, k);
        System.out.println(answer);
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int minusNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                minusNum++;
            }
        }
        int answer = 0;
        if (minusNum < k) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    nums[i] = nums[i] * -1;
                    k--;
                }
            }
            if (k % 2 == 0) {
                for (int i = 0; i < nums.length; i++) {
                    answer += nums[i];
                }
                return answer;
            } else {
                Arrays.sort(nums);
                for (int i = 1; i < nums.length; i++) {
                    answer += nums[i];
                }
                return answer - nums[0];
            }
        } else if (minusNum > k) {
            for (int i = 0; i < nums.length && k > 0; i++) {
                if (nums[i] < 0) {
                    nums[i] = nums[i] * -1;
                    k--;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                answer += nums[i];
            }
            return answer;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = nums[i] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            answer += nums[i];
        }
        return answer;
    }
}
