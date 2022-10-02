package com.company.from1to100.problem69;

public class Problem69 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 15;
        int answer = solution.mySqrt(x);
        System.out.println(answer);
    }
}

class Solution {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}
