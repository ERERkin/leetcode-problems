package com.company.from1to100.problem7;

public class Problem7 {

    public static void main(String[] args) {

    }
}

class Solution {
    public int reverse(int x) {
        String a = "" + x;
        String ans = "";
        if(a.charAt(0) == '-'){
            ans = "-";
            for(int i = a.length() - 1; i > 0; i--){
                ans = ans + a.charAt(i);
            }
        }else{
            for(int i = a.length() - 1; i >= 0; i--){
                ans = ans + a.charAt(i);
            }
        }
        long ret = Long.parseLong(ans);
        if(ret < -2147483648){
            return 0;
        }else if(ret > 2147483647){
            return 0;
        }
        return (int) ret;
    }
}
