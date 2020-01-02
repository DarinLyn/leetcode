package com.darin.leetcode.code;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
//        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public static String convert1(String s, int numRows) {
       if(numRows == 1) return s;

       List<StringBuilder> stringBuilders = new ArrayList<>();
       numRows = Math.min(s.length(), numRows);
       for(int i = 0; i < numRows; i++){
           stringBuilders.add(new StringBuilder());
       }

       int curRow = 0;
       boolean goingDown = false;
       for(char c : s.toCharArray()){
           stringBuilders.get(curRow).append(c);
           if(curRow == 0||curRow == numRows -1) goingDown = !goingDown;
           curRow += goingDown?1:-1;
       }

       StringBuilder ansSb = new StringBuilder();
       for(StringBuilder sb: stringBuilders){
           ansSb.append(sb);
       }

       return ansSb.toString();
    }

    public static String convert2(String s, int numRows) {
        if(numRows==1) return s;
        int column = (int)Math.ceil((double)s.length()/ (double)(2*numRows - 2)) * 2;
        char[][] charArr = new char[numRows][column];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i+1 <= numRows){ //0 - numRows
                charArr[i][0] = c;
            }else if(numRows< i+1 && i+1 <= 2*numRows - 2){ //numRows - (numRows+numRows-2)
                charArr[numRows - 1 -(i+1)%numRows][1] = c;
            }else {
                int r = (i+1) % (2*numRows - 2); //余数 6 2
                int f = (i+1) / (2*numRows - 2); //商  6 1

                if(r == 0){
                    r = 2*numRows - 2;
                    f--;
                }
                if(r <= numRows){
                    charArr[r-1][2*f] = c; //1 2
                }else {
                    charArr[2*numRows - r - 1][2*f+1] = c;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArr.length; i++){
            for(int j = 0; j < charArr[i].length; j++){
                if(charArr[i][j] != '\u0000') {
                    sb.append(charArr[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
