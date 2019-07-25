package com.colon.leetcode.practice;

import java.util.Scanner;

public class NO4_MedianOfTwoSortedArray {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int i = scan.nextInt();
            if(i == 0) break;
            int a = findXInArray(new int[]{2,4,6},i);
            System.out.println(a);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            int littleOrder = (nums2.length - 1) / 2;
            double little = nums2[littleOrder];
            if(nums2.length % 2 == 0){
                double large = nums2[littleOrder + 1];
                return (little + large) / 2;
            }else{
                return little;
            }
        }else if(nums2.length == 0){
            int littleOrder = (nums1.length - 1) / 2;
            double little = nums1[littleOrder];
            if(nums1.length % 2 == 0){
                double large = nums1[littleOrder + 1];
                return (little + large) / 2;
            }else{
                return little;
            }
        }
        int[] numMin,numMax;
        if(nums1.length > nums2.length){
            numMax = nums1;
            numMin = nums2;
        }else{
            numMax = nums2;
            numMin = nums1;
        }
        int length = numMax.length + numMin.length;
        int before = (length - 1) / 2;
        int difference = before - numMin.length;
        int start = 0;
        int end = numMin.length;
        int mid = start;
        while(true){
            int j = before - mid - 1;
            if((j == -1 || numMin[mid] >= numMax[j]) && (j == numMax.length - 1 || numMin[mid] <= numMax[j+1])){
                if(length % 2 == 0){
                    double little = numMin[mid],large;
                    if(mid == numMin.length - 1){
                        large = numMax[j+1];
                    }else{
                        large = Math.min(numMin[mid+1],numMax[j+1]);
                    }
                    return (little + large) / 2;
                }else{
                    return numMin[mid];
                }
            }else if(j != -1 || numMin[mid] < numMax[j]){
                start = mid;
                mid = (start + end + 1) / 2;
            }else{
                if(end == mid) break;
                end = mid;
                mid = (start + end + 1) / 2;
            }
        }
        start = 0 + difference;
        end = before;
        mid = start;
        while(true){
            int j = before - mid - 1;
            if((j == -1 || numMax[mid] >= numMin[j]) && (j == numMin.length - 1 || numMax[mid] <= numMin[j+1])){
                if(length % 2 == 0){
                    double little = numMax[mid],large;
                    if(j == numMin.length - 1){
                        large = numMax[mid+1];
                    }else{
                        large = Math.min(numMin[j+1],numMax[mid+1]);
                    }
                    return (little + large) / 2;
                }else{
                    return numMax[mid];
                }
            }else if(j != -1 || numMax[mid] < numMin[j]){
                start = mid;
                mid = (start + end + 1) / 2;
            }else{
                if(end == mid) break;
                end = mid;
                mid = (start + end + 1) / 2;
            }
        }
        return 0;
    }

    public static int findXInArray(int[] nums1,int x){
        int start = 0,end = nums1.length - 1;
        int mid = start;
        while (true) {
            if(nums1[mid] == x) return mid;
            if(nums1[mid] < x){
                start = mid;
                mid = (start + end + 1) / 2;
            }else{
                end = mid;
                mid = (start + end + 1) / 2;
            }
        }
    }
}
