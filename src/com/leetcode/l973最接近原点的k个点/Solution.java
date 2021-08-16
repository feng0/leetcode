package com.leetcode.l973最接近原点的k个点;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] kClosest(int[][] points,int K){
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (int)(Math.pow(o1[0],2)-Math.pow(o2[0],2)+Math.pow(o1[1],2) - Math.pow(o2[1],2));
            }
        });

        return Arrays.copyOfRange(points,0,K);
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        int[][] res = solution.kClosest(points,K);
        for(int[] a:res){
            System.out.println(Arrays.toString(a));
        }
    }
}
