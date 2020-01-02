package com.darin.leetcode.code;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch1("aab", "c*a*b"));
    }

    /**
     * 回溯匹配
     * 1. 临界条件：如果匹配串已经空了，匹配串不为空则没匹配完，返回false
     * 2. 拿到第一个字符是否匹配成功的属性。
     * 3. 如果匹配串前两个字符是x* 3.1和3.2满足任意条件都为true
     *   3.1 *表示匹配0个，匹配串减2继续回溯
     *   3.2 *表是匹配多个，如果第一个字符已经匹配成功了，字符串减1继续回溯
     * 4. 如果匹配串前两个字符不是x*，如果首字符不匹配则返回false，如果匹配则两个串减1则继续回溯
     * @param text 字符串
     * @param pattern 匹配串
     * @return
     */
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty(); //如果匹配串为空，则如果字符串为空则说明完全匹配，如果字符串不为空则说明不匹配（还有没有匹配完的字符串）
        boolean first_match = (!text.isEmpty() && //第一个字符是不是匹配  字符串不为空（此时匹配串也不为空）且匹配串与字符串的第一个字符匹配则为true
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){ //当匹配字符串长度有2或以上以及匹配串的第二个字符是*时
            return (isMatch(text, pattern.substring(2)) || //*当作0个时，去掉匹配串的x*然后继续回溯
                    (first_match && isMatch(text.substring(1), pattern))); //*当作n个时，如果两个串的首字母不匹配返回false，如果匹配就匹配掉字符串的一个字符，字符串减掉一位，接着回溯
        } else { //当匹配串长度为1，或者长度大于2但第二个字符串不是*
            //当匹配串长度为1时，如果该字符与字符串第一个字符不匹配就false，如果匹配则减掉一位再回溯看看字符串是否还有剩余未匹配字符串
            //当匹配串长度大于2时，如果不匹配则直接返回false，如果匹配减掉一位继续回溯
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;

    public boolean isMatch1(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
