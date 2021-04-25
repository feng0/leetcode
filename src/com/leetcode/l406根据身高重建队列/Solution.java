package com.leetcode.l406根据身高重建队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people){

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }else{
                    return o1[1]-o2[1];
                }

            }
        });

        System.out.println();
        List<int[]> list = new LinkedList<>();
        for(int[] p:people){
            list.add(p[1],p);
        }
        return list.toArray(people);
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        s.reconstructQueue(people);
    }
}
