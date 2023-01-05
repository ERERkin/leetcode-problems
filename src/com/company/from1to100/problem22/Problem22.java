package com.company.from1to100.problem22;

import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}

class Solution {
    private List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        List<Character> characters = new ArrayList<>();
        characters.add('(');
        find(characters, 1, n * 2);
        return answer;
    }

    private void find(List<Character> characters, int index, int n) {
        if (characters.size() == n) {
            addAnswer(characters);
            return;
        }

        characters.add('(');
        if (check(characters, index, n)) {
            find(characters, index + 1, n);
        }
        characters.remove(index);

        characters.add(')');
        if (check(characters, index, n)) {
            find(characters, index + 1, n);
        }
        characters.remove(index);
    }

    private boolean check(List<Character> characters, int index, int n) {
        int opened = 0;
        int closed = 0;
        for (Character character : characters) {
            if (character == '(') {
                opened++;
            }
            if (character == ')') {
                closed++;
            }
            if (closed > opened) {
                return false;
            }
        }
        if (opened > n / 2) {
            return false;
        }
        if (characters.size() == n && opened != closed) {
            return false;
        }
        return true;
    }

    private void addAnswer(List<Character> characters) {
        StringBuilder thisAnswer = new StringBuilder();
        for (int i = 0; i < characters.size(); i++) {
            thisAnswer.append(characters.get(i));
        }
        answer.add(thisAnswer.toString());
    }
}
