package com.darin.leetcode.code;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(())"));
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())()()("));
        System.out.println(new LongestValidParentheses().longestValidParentheses("((())"));
    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        //从左到右
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            else right++;
            if(left == right) //( 数量等于 )
                max = Math.max(max, right * 2);
            if(right > left) //需要重置的顺序，例 )(   (()))  ()())
                left = right = 0;
        }

        left = right = 0;

        //从右到左
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == '(') left++;
            else right++;
            if(left == right) //( 数量等于 )
                max = Math.max(max, right * 2);
            if(left > right) //需要重置的顺序，例 ((()) (()()
                left = right = 0;
        }

        return max;
    }

    public int longestValidParentheses1(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){ //当为(时加入栈，当为)时弹出栈顶(的下标，与(的上一位下标相减得到长度
            if(s.charAt(i) == '(') stack.push(i);
            else { // s.charAt(i) == ')'
                stack.pop();
                if(stack.empty()) stack.push(i);
                else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
