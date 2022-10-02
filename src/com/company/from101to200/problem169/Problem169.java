package com.company.from101to200.problem169;

import java.util.HashMap;
import java.util.Map;

public class Problem169 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1,1,1,1,2,1};
        int answer = solution.majorityElement(nums);
        System.out.println(answer);
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], 0);
            }
            Integer count = hashMap.get(nums[i]) + 1;
            hashMap.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> item : hashMap.entrySet()){
            if (item.getValue() > nums.length / 2){
                return item.getKey();
            }
        }
        return 0;
    }
}