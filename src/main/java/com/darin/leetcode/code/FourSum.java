package com.darin.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {

    public static void main(String[] args) {
        System.out.println(new FourSum().getFourSum(new int[]{-5, -5, -3, -1, 0, 2, 4, 5}, -7));
    }

    public List<List<Integer>> getFourSum(int[] nums,int target) {
        /*定义一个返回值*/
        List<List<Integer>> result = new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if (nums == null || nums.length < 4) {
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length = nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for (int k = 0; k < length - 3; k++) {
            /*当k的值与前面的值相等时忽略*/
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for (int i = k + 1; i < length - 2; i++) {
                /*当i的值与前面的值相等时忽略*/
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                /*定义指针j指向i+1*/
                int j = i + 1;
                /*定义指针h指向数组末尾*/
                int h = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> getFourSum1(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length < 4) return result;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-3; i++){
            int value = nums[i];

            result.addAll(getThreeSum(target-value, Arrays.copyOfRange(nums, i+1, nums.length))
                    .stream()
                    .map(d -> {
                        List<Integer> temp = new ArrayList<>(d);
                        temp.add(value);
                        return temp;
                    }).collect(Collectors.toList()));
            while (i < nums.length-3&&nums[i]==nums[i+1]) i++;
        }
        return result;
    }

    private List<List<Integer>> getThreeSum(int target, int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for(int index = 0; index<nums.length; index++){ //如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
            if(index>0&&nums[index] == nums[index - 1]) continue; //如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
            int left = index + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[index] + nums[left] + nums[right];
                if(sum < target) left++;
                if(sum > target) right--;
                if(sum == target){
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    while(left < right&&nums[left] == nums[left+1]) left++; //当 sum = 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
                    while(left < right&&nums[right] == nums[right-1]) right--; //当 sum = 0 时，nums[R] = nums[R−1] 则会导致结果重复，应该跳过，R−−
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
