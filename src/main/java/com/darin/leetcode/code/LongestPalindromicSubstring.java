package com.darin.leetcode.code;


public class LongestPalindromicSubstring {

    public static int dp(int n) {
        n++;
        int ans[] = new int[n];
        int[] coins = {1, 3, 5};
        ans[0] = 0;
        for(int i = 1; i < n; i++){

            for(int j = coins.length - 1; j > 0; j--){
                ans[i] = Integer.MAX_VALUE;
                if(i - coins[j] >= 0) {
                    int k = i - coins[j];
                    ans[i] = Math.min(ans[i-1]+1, ans[k]+1);
                    break;
                }
            }
            ans[i] = Math.min(ans[i-1]+1, ans[i]);
        }

        return ans[n-1];
    }

    public static String longestPalindrome1(String s) {
        String ans = s!=null&&s.length()>0?s.substring(0,1):"";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String subStr = s.substring(i, j + 1);
                if(isPalindrome(subStr) && ans.length() < subStr.length())
                    ans = subStr;
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String subStr) {
        for(int i = 0, j = subStr.length() -1; i<j; i++, j--){
            if(subStr.charAt(i) != subStr.charAt(j))
                return false;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if(s==null||s.length()==0) return "";
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){    //abba aba
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {

        //        System.out.println(dp(9));

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("abcda"));
        System.out.println(longestPalindrome("babadada"));

    }
}
