package com.leetcode.l941有效的山脉数组;

public class Solution {
    public boolean validMountainArray(int[] A){
        if(A.length<3){
            return false;
        }

        int p1=0;
        int p2=A.length-1;

        while(p1<A.length-1 && A[p1]<A[p1+1]){
            p1++;

        }

        while(p2>0 && A[p2]<A[p2-1]){
            p2--;
        }

        if(p1 == p2 && p1 != 0 && p2!=A.length-1){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] A = {0,1,2,3,4,5,6,7,8,9};
        boolean res = solution.validMountainArray(A);
        System.out.println(res);
    }
}
