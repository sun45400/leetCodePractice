package com.colon.leetcode.practice;

public class NO50_PowXN {

    public static void main(String[] args){
        double d = myPow(2.00000,10);
        return ;
    }

    public static double myPow(double x, int n) {
        int last = n,count = 0;
        double ans = 1.0;
        if(n == 0) return 1;
        if(n < 0) {
            last = 0 - n - 1;
            x = (1.0 / x);
            ans = x;
            count ++;
        }else{
            last = n - 1;
            ans = x;
            count ++;
        }
        while(last > 0){
            if(last - count * 2 > 0) {
                ans = ans * ans;
                last -= count;
                count *= 2;
            }else{
                ans = ans * myPow(x,last);
                last = 0;
            }
        }
        return ans;
    }
}
