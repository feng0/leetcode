package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class L46 {

    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track);
        return res;
    }

    static void  backTrack(int[] nums,LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums,track);

            track.removeLast();
        }
    }
}
