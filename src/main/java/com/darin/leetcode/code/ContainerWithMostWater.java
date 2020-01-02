package com.darin.leetcode.code;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for(int j = height.length -1; j > 0; j--){
            for(int i = j - 1; i >= 0; i--){
                max = Math.max(max, Math.min(height[j], height[i])*(j-i));
            }
        }
        return max;
    }

    public int maxArea1(int[] height){
        int max = 0;
        int i = 0, j = height.length-1;
        while(i<=j){
            max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
            if(height[i] > height[j]){
                j--;
            }else {
                i++;
            }
        }

        return max;
    }
}
