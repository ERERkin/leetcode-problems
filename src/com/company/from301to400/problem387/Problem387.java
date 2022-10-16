package com.company.from301to400.problem387;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem387 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabaa";
        int answer = solution.firstUniqChar(s);
        System.out.println(answer);
    }
}

class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Value> charactersNumbers = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character currentCharacter = s.charAt(i);
            if (!charactersNumbers.containsKey(currentCharacter)){
                charactersNumbers.put(currentCharacter, new Value(i, 1));
            } else {
                Value currentValue = charactersNumbers.get(currentCharacter);
                currentValue.count++;
                charactersNumbers.put(currentCharacter, currentValue);
            }
        }
        for (Map.Entry<Character, Value> characterNum: charactersNumbers.entrySet()){
            if (characterNum.getValue().count == 1) {
                return characterNum.getValue().firstNum;
            }
        }

        return  -1;
    }
}

class Value {
    int firstNum;
    int count;

    public Value (int firstNum, int count) {
        this.firstNum = firstNum;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Value{" +
                "firstNum=" + firstNum +
                ", count=" + count +
                '}';
    }
}