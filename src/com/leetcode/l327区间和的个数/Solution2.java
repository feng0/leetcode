package com.leetcode.l327区间和的个数;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args){
        Solution2 solution = new Solution2();
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        int lower = -564;
        int upper = 3864;
        int res = solution.countRangeSum(nums,lower,upper);
        System.out.println(res);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        System.out.println(Arrays.toString(sum));
        int cnt = 0;
        for(int i=0;i<sum.length;i++){
            for(int j=i+1;j<sum.length;j++){
                long cha = (sum[j] - sum[i]);
                if( cha>=lower && cha<=upper){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
