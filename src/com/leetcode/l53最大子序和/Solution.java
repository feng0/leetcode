package com.leetcode.l53最大子序和;

public class Solution {

    /**
     * 动态规划 先求f(i)=max{f(i-1)+a[i],a[i]},在求f(i)的最大值
     * */
    public int maxSubArray(int[] nums){
        int pre=0,maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            pre = Math.max(pre+nums[i],nums[i]);
            maxSum = Math.max(maxSum,pre);
        }

        return maxSum;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int res = solution.maxSubArray(arr);
        System.out.println(res);
    }
}
