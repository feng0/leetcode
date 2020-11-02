package com.leetcode.l349两个数组的交集;

import java.util.*;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i:nums1){
            if(i>max){
                max = i;
            }
            if(i<min){
                min = i;
            }
        }
        boolean[] arr1 = new boolean[max- min + 1];
        for(int i:nums1){
            arr1[i-min] = true;
        }
        for(int i:nums2){
            if(i>=min && i<= max && arr1[i-min]){
                arr1[i-min] = false;
                list.add(i);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>(nums1.length,1);
        for(int i:nums1){
            map.put(i,true);
        }
        List<Integer> list = new ArrayList<>();
        for(int i:nums2){
            if(map.containsKey(i) && map.get(i)){
                list.add(i);
                map.put(i,false);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] a = solution.intersection(nums1,nums2);
        System.out.println(Arrays.toString(a));
    }
}
