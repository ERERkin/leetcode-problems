package com.company.from1to100.problem17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("234"));
    }
}

class Solution {
    private List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        Map<Character, Character[]> characterMap = getInfo();
        int n = digits.length();
        Character[] digitsArray = new Character[n];
        for (int i = 0; i < n; i++) {
            digitsArray[i] = digits.charAt(i);
        }
        Character thisCharacter = digitsArray[0];
        Character[] thisCharacterArray = characterMap.get(thisCharacter);
        for (int i = 0; i < thisCharacterArray.length; i++) {
            find("" + thisCharacterArray[i], digitsArray, characterMap, 1);
        }
        return answer;
    }

    private Map<Character, Character[]> getInfo() {
        Map<Character, Character[]> characterMap = new HashMap<>();
        characterMap.put('2', new Character[]{'a', 'b', 'c'});
        characterMap.put('3', new Character[]{'d', 'e', 'f'});
        characterMap.put('4', new Character[]{'g', 'h', 'i'});
        characterMap.put('5', new Character[]{'j', 'k', 'l'});
        characterMap.put('6', new Character[]{'m', 'n', 'o'});
        characterMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        characterMap.put('8', new Character[]{'t', 'u', 'v'});
        characterMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        return characterMap;
    }

    private void find(String answerString, Character[] digits, Map<Character, Character[]> characterMap, int index) {
        if (answerString.length() == digits.length) {
            answer.add(answerString);
            return;
        }
        Character thisDigit = digits[index];
        Character[] thisCharacterArray = characterMap.get(thisDigit);
        for (int i = 0; i < thisCharacterArray.length; i++) {
            find(answerString + thisCharacterArray[i], digits, characterMap, index + 1);
        }
    }

}