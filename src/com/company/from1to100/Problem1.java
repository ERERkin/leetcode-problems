package com.company.from1to100;

//Two sum
public class Problem1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[1], 0);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
