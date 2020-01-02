package com.darin.leetcode.code;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int i =0;
        int x1 = x;
        while (x1>0){
            i = i*10 + x1%10;
            x1 = x1/10;
        }
        return i == x;
    }
}
