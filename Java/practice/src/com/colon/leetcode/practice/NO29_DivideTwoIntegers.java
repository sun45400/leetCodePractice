package com.colon.leetcode.practice;

public class NO29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        if(dividend > 0 && divisor < 0){
            dividend = 0 - dividend;
            return 0 - divideSimple(dividend,divisor);
        }else if (dividend < 0 && divisor > 0){
            divisor = 0 - divisor;
            return 0 - divideSimple(dividend,divisor);
        }else{
            return divideSimple(dividend,divisor);
        }
    }

    public int divideSimple(int dividend, int divisor){
        int temp = 0;
        while(true){

        }
    }
}
