package com.darin.leetcode.code.greedy;

import java.util.*;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbaca defegde hijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        String s = "aazbz";
        System.out.println(new PartitionLabels().partitionLabels(s));
    }

    /**
     * 定义数组 last[char] 来表示字符 char 最后一次出现的下标。
     * 定义 anchor 和 j 来表示当前区间的首尾。
     * 如果遇到的字符最后一次出现的位置下标大于 j， 就让 j=last[c] 来拓展当前的区间。
     * 当遍历到了当前区间的末尾时(即 i==j )，把当前区间加入答案，同时将 start 设为 i+1 去找下一个区间。
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0; //记录起点
        int end = 0; //记录终点
        List<Integer> ansList = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            end = Math.max(lastIndex[s.charAt(i) - 'a'], end); //end一定为答案某字段的结尾下标
            if(i == end){ //已经到结尾了
                ansList.add(end - start + 1);
                start = end + 1;
            }
        }

        return ansList;
    }


    public List<Integer> partitionLabels1(String s) {
        Map<Character, Integer[]> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new Integer[]{i ,i});
            }else {
                Integer[] arr = map.get(c);
                arr[1] = i;
            }
        }

        List<Integer[]> list = new ArrayList(map.values());
        List<Integer> ansList = new ArrayList<>();
        int start = 0, end = -1;
        for(Integer[] arr: list){
            if(end == -1){
                start = arr[0];
                end = arr[1];
            }else if(arr[0] < end){
                end = Math.max(end, arr[1]);
            }else if(arr[0] > end){
                ansList.add(end - start + 1);
                start = arr[0];
                end = arr[1];
            }
        }
        ansList.add(end - start + 1);

        return ansList;
    }
}
