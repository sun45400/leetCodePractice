package com.colon.leetcode.practice;

public class NO33_34_SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return -1;
        if(length == 1) return nums[0] == target ? 0 : -1;
        int min = 0;
        if(nums[0] > nums[length - 1]){
            int start = 0,end = length - 1,mid = 0;
            if(nums[0] == target) return 0;
            while(true){
                mid = (start + end + 1)/ 2;
                if(nums[mid] == target) return mid;
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
        int start = min,end = min + length - 1,mid = min;
        if(nums[mid] == target) return mid;
        while(start != end){
            mid = (start + end + 1)/ 2;
            int midIndex = mid % length;
            if(nums[midIndex] == target) return midIndex;
            if (nums[midIndex] > target) {
                if(end == mid) break;
                end = mid;
            }else{
                start = mid;
            }
        }
        return -1;
    }


    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int first = -1,last = -1;
        if(nums.length != 0 && nums[0] <= target && nums[nums.length - 1] >= target){
            if(nums[0] == target) first = 0;
            else {
                int start = 0, end = nums.length - 1, mid;
                while (start != end) {
                    mid = (start + end + 1) / 2;
                    if (nums[mid] == target && nums[mid - 1] < target) {
                        first = mid;
                        break;
                    } else if (nums[mid] >= target) {
                        if (end == mid) break;
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
            }
            if(first != -1){
                int start = first,end = nums.length - 1,mid = start;
                if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)){
                    last = mid;
                }else {
                    while (true) {
                        mid = (start + end + 1) / 2;
                        if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {
                            last = mid;
                            break;
                        } else if (nums[mid] > target) {
                            end = mid;
                        } else {
                            start = mid;
                        }
                    }
                }
            }
        }
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
}
