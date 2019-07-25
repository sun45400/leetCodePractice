package com.colon.leetcode.practice;

import java.util.ArrayDeque;
import java.util.Deque;


public class NO239_SlidingWindowMaximum {

    public static void main(String[] args){
        NO239_SlidingWindowMaximum a = new NO239_SlidingWindowMaximum();
        a.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length * k == 0) return new int[0];
        if(k == 1) return nums;
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque();
        window.add(0);
        for(int i = 0;i < k;i ++){
            if(window.peek() == i - k) window.remove();
            while(!window.isEmpty() && nums[window.getLast()] <= nums[i]){
                window.removeLast();
            }
            window.add(i);
        }
        ans[0] = nums[window.getFirst()];
        for(int i = k, j = 1;i < nums.length; i ++){
            if(window.peek() == i - k) window.remove();
            while(!window.isEmpty() && nums[window.getLast()] <= nums[i]){
                window.removeLast();
            }
            window.add(i);
            if(i >= k - 1){
                ans[j++] = nums[window.getFirst()];
            }
        }
        return ans;
    }
}
