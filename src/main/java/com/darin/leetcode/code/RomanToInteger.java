package com.darin.leetcode.code;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int result = 0;

        int[] intArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < strArr.length; i++){
            int pLength  = strArr[i].length();
            while (s.length() >= pLength && s.substring(0, pLength).equals(strArr[i])){
                s = s.substring(pLength);
                result += intArr[i];
            }
        }

        return result;
    }
}
