package com.darin.leetcode.code;

public class RerverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE -1));
    }

    public static int reverse(int x){
        int rev = 0;

        while(x!=0){
            int pop = x%10;
            x = x/10;
            if(rev > Integer.MAX_VALUE/10) return 0;
            if(rev < Integer.MIN_VALUE/10) return 0;
            rev = rev*10+pop;
        }
        return rev ;
    }
}
