package com.darin.leetcode.code;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
//        String str1 = "flower";
//        String str2 = "flow";
//        System.out.println(str1.indexOf(str2));
    }

    /**
     * 1. 获取最短字符串的1/2长度str
     * 2. 遍历所有字符串，如果不是以str开始的，就返回false
     * 3. 如果都是true，往上移一位继续遍历
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    /**
     * 1. 把第一个字符串设置为前缀
     * 2. 从第二字符串开始，查找前缀在该字符串的索引，没有则返回-1，前缀长度-1继续匹配，有则返回零，将当前前缀往下循环。如果前缀已经为空说明匹配不到，直接return "";
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
       if(strs.length == 0) return "";
       String prefix = strs[0];
       for(int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() -1);
                if(prefix.isEmpty()) return "";
            }
       }
       return prefix;
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs==null||strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        char[] charArr = strs[0].toCharArray();
        int charIndex= Integer.MAX_VALUE;
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            while (j<charArr.length&&j<strs[i].length()&&strs[i].charAt(j) == charArr[j]){
                j++;
            }
            charIndex = Math.min(charIndex, j);
        }
       return new String(Arrays.copyOfRange(charArr, 0, charIndex));
    }


}
