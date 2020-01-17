package com.darin.leetcode.code;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinationSum {

    public static void main(String[] args) {
//        int candidates[] = {8,7,4,3};
        int candidates[] = {2,3,6,7};
        System.out.println(new CombinationSum().combinationSum(candidates, 7));
    }

    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
//        Arrays.sort(candidates);
        buildList(list, candidates, target, 0);

        return ansList;
    }

    private void buildList(List<Integer> list, int[] candidates, int target, int startIndex) {

        if (target == 0) {
            ansList.add(list);
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0){
                continue;
//                return;
            }
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(candidates[i]);

            buildList(temp, candidates, target - candidates[i], i);
        }
        return;
    }
}
