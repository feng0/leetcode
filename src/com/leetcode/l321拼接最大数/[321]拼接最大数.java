//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 202 👎 0
package com.leetcode.l321拼接最大数;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxSubsequence= new int[k];
        int start = Math.max(0,k-n);
        int end = Math.min(k,m);
        for(int i=start;i<=end;i++){
            int[] arr1 = maxSubsequence(nums1,i);
            int[] arr2 = maxSubsequence(nums2,k-i);
            int[] curMaxSubsequence = merge(arr1,arr2);
            if(compare(curMaxSubsequence,0,maxSubsequence,0)>0){
                System.arraycopy(curMaxSubsequence,0,maxSubsequence,0,k);
            }
        }
        return maxSubsequence;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        int k=5;
        int[] res = solution.maxNumber(nums1,nums2,k);
        System.out.println(Arrays.toString(res));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    public int[] merge (int[] sub1,int[] sub2){
        if(sub1.length == 0){
            return sub2;
        }
        if(sub2.length == 0){
            return sub1;
        }
        int mergeLength = sub1.length + sub2.length;
        int[] merged = new int[mergeLength];
        int index1 = 0,index2 = 0;
        for(int i=0;i<mergeLength;i++){
            if(compare(sub1,index1,sub2,index2)>0){
                merged[i] = sub1[index1++];
            }else{
                merged[i] = sub2[index2++];
            }
        }

        return merged;
    }

    public int compare(int[] sub1,int index1,int[] sub2,int index2){
        int x = sub1.length,y=sub2.length;
        while(index1<x && index2<y){
            int diff = sub1[index1] - sub2[index2];
            if(diff != 0){
                return diff;
            }
            index1++;
            index2++;
        }
        return (x-index1) - (y-index2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
