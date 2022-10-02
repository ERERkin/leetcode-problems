package com.company.from1to100.problem53;

public class Problem53 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, -1};
        int answer = solution.maxSubArray(nums);
        System.out.println(answer);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSubArraySum = nums[0];
        int maxSubArraySum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > currentSubArraySum + nums[i]) {
                currentSubArraySum = nums[i];
            } else {
                currentSubArraySum += nums[i];
            }

            if (currentSubArraySum > maxSubArraySum){
                maxSubArraySum = currentSubArraySum;
            }
        }

        return maxSubArraySum;
    }
}