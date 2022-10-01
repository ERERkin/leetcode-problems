package com.company.from1to100.problem91;

public class Problem91 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "230";
        int answer = solution.numDecodings(s);
        System.out.println(answer);
    }
}

class Solution {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] digits = new int[s.length()];
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            digits[i] = s.charAt(i) - '0';
            dp[i] = 0;
        }

        dp[0] = 1;
        if (isLetter(digits[1])) dp[1]++;
        if (isLetter(digits[0] * 10 + digits[1])) dp[1]++;

        for (int i = 2; i < s.length(); i++){
            if (digits[i] == 0){
                if (digits[i - 1] == 0){
                    return 0;
                }
                if (digits[i - 1] > 2) {
                    return 0;
                }
                dp[i] = dp[i - 2];
                continue;
            }
            if (digits[i - 1] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            if (isLetter(digits[i - 1] * 10 + digits[i])){
                dp[i] = dp[i - 2] + dp[i - 1];
                continue;
            }
            if (!isLetter(digits[i - 1] * 10 + digits[i]) &&
                    !isLetter(digits[i - 2] * 10 + digits[i - 1])){
                dp[i] = dp[i - 1];
            }
            dp[i] = dp[i - 1];
        }
        return dp[s.length() - 1];
    }

    boolean isLetter (int number){
        if (number >= 1 && number <= 26) return true;
        return false;
    }
}
