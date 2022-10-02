package com.company.from201to300.problem229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem229 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2};
        List<Integer> answer = solution.majorityElement(nums);
        System.out.println(answer);
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], 0);
            }
            Integer count = hashMap.get(nums[i]) + 1;
            hashMap.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> item : hashMap.entrySet()){
            if (item.getValue() > nums.length / 3){
                answerList.add(item.getKey());
            }
        }
        return answerList;
    }
}
