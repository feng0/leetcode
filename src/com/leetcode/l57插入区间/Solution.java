package com.leetcode.l57插入区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean flag = false;
        if(intervals.length == 0){
            int[][] res = {newInterval};
            return res;
        }
        List<int[]> list = new ArrayList<>();
        int begin = newInterval[0];int end = newInterval[1];
        for(int i=0;i<intervals.length;i++){
            int[] old = intervals[i];
            if(old[0]>end){
                if(!flag){
                    list.add(new int[]{begin,end});
                    flag = true;
                }
                list.add(old);
            }else if( old[1]<begin){
                list.add(old);
            }else {
                if(old[0]<begin){
                    begin = old[0];
                }
                if(old[1]>end){
                    end = old[1];

                }
            }

        }
        if(!flag){
            int[] insertOne = {begin,end};
            list.add(insertOne);
        }
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] intervals = {{1,3},{6,9}};//{{1,3},{6,9}};//{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {2,5};//{4,8};

        int[][] res = solution.insert(intervals,newInterval);

        for(int[] i:res){
            System.out.print(Arrays.toString(i) + " ");
        }


    }
}
