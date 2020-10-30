package com.leetcode.l1207独一无二的出现次数;

public class Solution {
    public static boolean uniqueOccurrences(int[] arr) {
        int[] temp = new int[2000];
        for(int i=0;i<arr.length;i++){
            temp[arr[i] + 1000] += 1;
        }

        for(int i=0;i<temp.length;i++){
            if(temp[i]!=0){
                for(int j=i+1;j<temp.length;j++){
                    if(temp[i] == temp[j]){
                        return false;
                    }
                }
            }

        }

        return true;
    }

    public static void main(String[] args){
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        boolean res = uniqueOccurrences(arr);
        System.out.println(res);
    }
}
