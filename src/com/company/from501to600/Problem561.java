package com.company.from501to600;

import java.util.Arrays;

public class Problem561 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{6, 2, 6, 5, 1, 2};
        int answer = solution.arrayPairSum(nums);
        System.out.println(answer);
    }
}

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length; i += 2) {
            answer += Math.min(nums[i], nums[i + 1]);
        }
        return answer;
    }
}