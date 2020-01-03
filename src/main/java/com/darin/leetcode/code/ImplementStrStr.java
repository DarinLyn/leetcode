package com.darin.leetcode.code;

public class ImplementStrStr {

    public static void main(String[] args) {
        String base = "mississippi";
        System.out.println(new ImplementStrStr().strStr(base, "issip"));
    }

    /**
     * Double pointer
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for(int i = 0; i < n - m + 1; i ++)
        {
            int j = 0;
            for( ; j < m; j ++)
            {
                if(haystack.charAt(i + j) !=  needle.charAt(j))
                    //为了保证在这个循环里haystack的索引也跟着needle索引一起向前推进，i的含义设置为起始点，i + j才是haystack的索引
                    break;
            }
            if(j == m)
                return i;
        }
        return -1;
    }

    /**
     * solution 1
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        if(needle==null || needle.isEmpty()) return 0;
        int length = needle.length();
        for(int i = 0; i < haystack.length() - length + 1; i++){
            if(haystack.substring(i, i+length).equals(needle))
                return i;
        }
        return -1;
    }
}
