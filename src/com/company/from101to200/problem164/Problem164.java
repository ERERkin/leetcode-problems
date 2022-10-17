package com.company.from101to200.problem164;

import java.util.Arrays;

public class Problem164 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{11, 1, 17, 5, 13, 14, 3, 6, 8, 2};
        int answer = solution.maximumGap(nums);
        System.out.println(answer);
    }
}

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
            }
            if (minValue > nums[i]) {
                minValue = nums[i];
            }
        }
        if (minValue == maxValue) {
            return 0;
        }

        int bucketSize = (int) Math.ceil((double) (maxValue - minValue) / (nums.length - 1));

        int[] minBucket = new int[nums.length];
        int[] maxBucket = new int[nums.length];

        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - minValue) / bucketSize;
            minBucket[bucketIndex] = Math.min(nums[i], minBucket[bucketIndex]);
            maxBucket[bucketIndex] = Math.max(nums[i], maxBucket[bucketIndex]);
        }

        int answer = bucketSize;

        int previousMax = maxBucket[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxBucket[i] == Integer.MIN_VALUE) {
                continue;
            }

            answer = Math.max(answer, minBucket[i] - previousMax);
            previousMax = maxBucket[i];
        }

        return answer;
    }
}

