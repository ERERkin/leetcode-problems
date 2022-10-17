package com.company.from501to600.problem509;

public class Problem509 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int answer = solution.fib(n);
        System.out.println(answer);
    }
}

class Solution {
    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 2] + fibArray[i - 1];
        }
        return fibArray[n];
    }
}
