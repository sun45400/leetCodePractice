package com.colon.leetcode.practice;

public class NO153_FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 0) return -1;
        if(length == 1) return nums[0];
        int min = 0;
        if(nums[0] > nums[length - 1]){
            int start = 0,end = length - 1,mid = 0;
            while(true){
                mid = (start + end + 1)/ 2;
                if(nums[mid] < nums[mid - 1]) {
                    min = mid;
                    break;
                }else if(nums[mid] > nums[0]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        return nums[min];
    }
}
