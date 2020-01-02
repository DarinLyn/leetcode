package com.darin.leetcode.code;


public class IntegerToRoman {

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman1(1800));
    }


    public String intToRoman1(int num) {
        StringBuilder sb = new StringBuilder();

        int[] intArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < intArr.length; i++){
            while(num >= intArr[i]){
                sb.append(strArr[i]);
                num -= intArr[i];
            }
        }

        return sb.toString();
    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        if(num>899){
            //800-3999 contain m
            //num/1000 * m + (num%100 - 800) * c
            if(num >= 1000){//1001
                sb.append(new String(new char[num/1000]).replace("\0", "M"));
                return intToRoman(num - num/1000*1000);
            }else {//999
                sb.append(new String(new char[10 - num/100]).replace("\0", "C")).append("M");
                return intToRoman(num - num/100*100);
            }
        }else if(num > 399){
            //400 - 799 contain d no m
            //num - 500 * c
            if(num >=500){//501
                sb.append("D").append(new String(new char[(num-500)/100]).replace("\0", "C"));
                return intToRoman(num - num/100*100);
            }else {//499
                sb.append("CD");
                return intToRoman(num - 400);
            }
        }else if(num>89){
            //80 - 399 contain c no d
            //num/100 * c + (num%10 - 80) * x
            if(num>=100){
                sb.append(new String(new char[num/100]).replace("\0", "C"));
                return intToRoman(num - num/100*100);
            }else { //89
                sb.append(new String(new char[10 - num/10]).replace("\0", "X")).append("C");
                return intToRoman(num - num/10*10);
            }
        }else if(num>39){
            //40 - 79 contain l no c
            //num - 50 * l
            if(num >= 50){
                sb.append("L").append(new String(new char[(num-50)/10]).replace("\0", "X"));
                return intToRoman(num - num/10*10);
            }else {
                sb.append("XL");
                return intToRoman(num - 40);
            }
        }else if(num>8){
            //8 - 39 contain x no v
            //num/10* x + (num%10 - 8)*i
            if(num>=10){
                sb.append(new String(new char[num/10]).replace("\0", "X"));
                return intToRoman(num - num/10*10);
            }else {
                return sb.append(new String(new char[10 - num]).replace("\0", "I")).append("X").toString();
            }
        }else{
            if(num >= 5){
                sb.append("V").append(new String(new char[num-5]).replace("\0", "I"));
            }else if(num == 4){
                sb.append("IV");
            }else if(num > 0){
                sb.append(new String(new char[num]).replace("\0", "I"));
            }
            return sb.toString();
        }
    }
}
