package com.colon.leetcode.practice;


import java.util.Stack;

public class NO32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        s = " " + s;
        int[] len = new int[s.length() + 1];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                len[i] = 0;
            }else if(s.charAt(i-1) == '(') {
                len[i] = 2 + len[i-2];
            }else if(i > 3 && s.charAt(i-1) == ')' && s.charAt(i-len[i-1] -1) == '('){
                len[i] = 2 + len[i-1] + len[i - len[i-1] -2];
            }else{
                len[i] = 0;
            }
        }
        int max = 0;
        for(int num : len){
            max = Math.max(max,num);
        }
        return max;
    }

    public int stackSolution(String s){
        if(s.length() < 2) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '(') stack.push(i);
            else if(stack.size() == 1){
                stack.pop();
                stack.push(i);
            }else{
                stack.pop();
                max = Math.max(max,i-stack.peek());
            }
        }
        return max;
    }
}
