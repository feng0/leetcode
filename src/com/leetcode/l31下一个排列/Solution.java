package com.leetcode.l31下一个排列;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums){
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
        System.out.println(Arrays.toString(nums));
    }
    public void swap(int[] nums,int i,int j){
        if(i<0 || j<0){
            return;
        }
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void reverse(int[] nums ,int start){
        int left = start;int right = nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {5,1,1};
        solution.nextPermutation(nums);
    }
}
