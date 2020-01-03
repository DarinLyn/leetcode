package com.darin.leetcode.code;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DivideTwoIntegers {

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(true^true);
//        System.out.println(new DivideTwoIntegers().divide(Integer.MIN_VALUE, -1));
    }

    /**
     * 1. 记录相除后结果的正负，都转化为负数相除，以解决负数转正数多一
     * 2. 使用下例相减除法
     *
     * 例: 45/2 = 22
     * 用二进制相除则为:
     *        10110
     * 10 / 101101
     *      10
     *       11
     *       10
     *        10
     *        10
     *         1
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor){
        boolean sign = (dividend > 0) ^ (divisor > 0); //记录答案正负 (^异或，两个值不同就返回true，相同则返回false)
        int result = 0;
        if(dividend > 0) dividend = -dividend; //除数转为负数
        if(divisor > 0) divisor = -divisor; //被除数转为负数
        while (dividend <= divisor) { //如果除数的绝对值还大于被除数的绝对值（由于都是负数，所以用小于）
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)){ //将被除数放大到除数最大那位
                if(temp_divisor <= (Integer.MIN_VALUE >> 1)){ //再放大就要超过Integer.MIN_VALUE了
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) { //两个数同符号，原答案为正
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE; //处理Integer.MIN_VALUE/-1
            result = - result;
        }
        return result;
    }
}
