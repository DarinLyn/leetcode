package com.darin.leetcode.code.greedy;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("cd", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c: s.toCharArray()){ //对于要匹配的s，如果s中的A字符在t的B位被匹配到了，那就从B+1开始匹配A+1的字符，如果没匹配到，直接返回false
            index = t.indexOf(c, index+1);
            if(index == -1) return false;
        }
        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        if(s.length() == 0) return true;
        int index = 0;
        for(char c : t.toCharArray()){
            if(index == s.length()) return true;
            if(s.charAt(index) == c) index++;
        }

        return index == s.length();
    }
}
