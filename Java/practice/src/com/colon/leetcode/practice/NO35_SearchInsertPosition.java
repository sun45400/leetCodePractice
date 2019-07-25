package com.colon.leetcode.practice;

public class NO35_SearchInsertPosition {



    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int start = 0,end = nums.length - 1,mid = start;
        if(nums[start] >= target) return 0;
        if(nums[nums.length - 1] < target) return nums.length;
        while(true){
            if(nums[mid] == target) return mid;
            if(nums[mid] < target && (mid == end || nums[mid + 1] > target)){
                return mid + 1;
            }else if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
            mid = (start + end + 1) / 2;
        }
    }
}
