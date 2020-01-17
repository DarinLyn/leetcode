package com.darin.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int candidates[] = {10,1,2,7,6,1,5};
        System.out.println(new CombinationSumII().combinationSum2(candidates, 8));
    }

    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i < candidates.length - 1&&candidates[i] == candidates[i+1]) i++;

            buildList(temp, candidates, target - candidates[i], i + 1);
        }
        return;
    }

}
