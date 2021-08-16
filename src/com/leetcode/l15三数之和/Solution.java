package com.leetcode.l15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int first=0;first<nums.length;first++){
            //排重，和上一次不一样
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int third = nums.length-1;
            int target = -nums[first];
            //枚举b
            for(int second=first+1;second<nums.length;second++){
                //排重，和上一次不一样
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                //需要保证b在c的左侧
                while(second<third && nums[second]+nums[third]>target){
                    --third;
                }
                if(second == third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
