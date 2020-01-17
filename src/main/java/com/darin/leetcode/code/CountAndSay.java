package com.darin.leetcode.code;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay1(5));
    }

    String ans = "1";


    public String countAndSay1(int n){
        n--;
        if(n == 0) {
            return ans;
        }else {
            StringBuilder sb = new StringBuilder();
            char curChar = ans.charAt(0);
            int count = 1;
            for(int j = 1; j < ans.length(); j++){
                if(ans.charAt(j) == curChar){
                    count++;
                }else {
                    sb.append(count).append(curChar);
                    curChar = ans.charAt(j);
                    count = 1;
                }
            }
            ans = sb.append(count).append(curChar).toString();

            return countAndSay1(n);
        }
    }

    public String countAndSay(int n) {
        String ans = "1";
        for(int i = 2; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            char curChar = ans.charAt(0);
            int count = 1;
            for(int j = 1; j < ans.length(); j++){
                if(ans.charAt(j) == curChar){
                    count++;
                }else {
                    sb.append(count).append(curChar);
                    curChar = ans.charAt(j);
                    count = 1;
                }
            }
            ans = sb.append(count).append(curChar).toString();
        }
        return ans;
    }
}
