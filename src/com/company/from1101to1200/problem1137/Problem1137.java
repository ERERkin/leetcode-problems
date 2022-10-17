package com.company.from1101to1200.problem1137;

public class Problem1137 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int answer = solution.tribonacci(n);
        System.out.println(answer);
    }
}

class Solution {
    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        int[] tribArray = new int[n + 1];
        tribArray[0] = 0;
        tribArray[1] = 1;
        tribArray[2] = 1;
        for (int i = 3; i <= n; i++) {
            tribArray[i] = tribArray[i - 1] + tribArray[i - 2] + tribArray[i - 3];
        }
        return tribArray[n];
    }
}
