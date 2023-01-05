package com.company.from701to800.problem771;

import java.util.HashMap;
import java.util.Map;

public class Problem771 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
    }
}

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < jewels.length(); i++) {
            hashMap.put(jewels.charAt(i), 0);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (hashMap.containsKey(stones.charAt(i))) {
                int count = hashMap.get(stones.charAt(i));
                hashMap.put(stones.charAt(i), count + 1);
            }
        }

        int answer = 0;

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            answer += entry.getValue();
        }

        return answer;
    }
}
