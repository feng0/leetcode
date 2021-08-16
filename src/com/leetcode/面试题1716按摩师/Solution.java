package com.leetcode.面试题1716按摩师;

public class Solution {
    public int massage(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int pre0= 0;
        int pre1 = nums[0];
        int current0 = 0;
        int current1 = 0;
        for(int i=1;i<nums.length;i++){
            current1 = pre0 + nums[i];
            current0 = Math.max(pre0,pre1);
            pre0 = current0;
            pre1 = current1;
        }

        return pre0>pre1?pre0:pre1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] nums  = {2,1,4,5,3,1,1,3};

        int resf = solution.massage(nums);
        System.out.println(resf);
    }
}
