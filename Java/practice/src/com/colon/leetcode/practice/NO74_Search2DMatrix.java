package com.colon.leetcode.practice;

public class NO74_Search2DMatrix {

    public static void main(String[] args){
        boolean a = searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},3);
        return ;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int length1=  matrix.length,length2 = matrix[0].length;
        int start = 0,end = length1 * length2 - 1,mid = start;
        if(matrix[start/length2][start%length2] > target || matrix[end/length2][end%length2] < target) return false;
        while(start != end){
            int i = mid/length2,j = mid%length2;
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] < target) start = mid;
            else end = mid;
            mid = (start + end + 1) / 2;
        }
        return matrix[end/length2][end%length2] == target;
    }
}
