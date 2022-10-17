package com.company.from1to100.problem11;

public class Problem11 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{1,1};
        int answer = solution.maxArea(height);
        System.out.println(answer);
    }
}

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int volumeOfWater = 0;
        while (i < j){
            int currentVolume = (j - i) * Math.min(height[i], height[j]);
            if (currentVolume > volumeOfWater){
                volumeOfWater = currentVolume;
            }
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }

        return volumeOfWater;
    }
}
