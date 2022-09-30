package com.company.from1001to11000.problem1013;

public class Problem1013 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0,2,1,-6,6,-7,9,1,2,0,1};
        boolean answer = solution.canThreePartsEqualSum(arr);
        System.out.println(answer);
    }
}

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int generalSum = 0;
        int dividedSum;
        for (int i = 0; i < arr.length; i++) {
            generalSum += arr[i];
        }
        if (generalSum % 3 != 0) {
            return false;
        }
        dividedSum = 0;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            dividedSum += arr[i];
            if (dividedSum == generalSum / 3) {
                dividedSum = 0;
                zeroCount++;
            }
        }
        return (zeroCount % 3 == 0 && zeroCount >= 3) ||
                (generalSum == 0 && zeroCount >= 3) ||
                (zeroCount % 3 == 1 && zeroCount >= 3 && (dividedSum + generalSum / 3 == 0)) ||
                (zeroCount % 3 == 2 && zeroCount >= 3 && (dividedSum + generalSum / 3 * 2 == 0));
    }
}
