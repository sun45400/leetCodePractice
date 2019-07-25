package com.colon.leetcode.practice;

public class NO162_FindPeekElement {

    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int start = 0,end = nums.length - 1,mid = start;
        if(nums[mid] > nums[mid+1]) return 0;
        while(true){
            mid = (start + end + 1) / 2;
            if(nums[mid] > nums[mid - 1]){
                if(mid == nums.length - 1 || nums[mid] > nums[mid + 1]){
                    return mid;
                }else{
                    start = mid;
                }
            }else{
                end = mid;
            }
        }
    }
}
