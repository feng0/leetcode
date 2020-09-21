package com.leetcode;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L4 {

    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double res = findMedianSortedArrays(nums1,nums2);
        System.out.println(res);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return getMid(nums2);
        }
        if(nums2 == null || nums2.length == 0){
            return getMid(nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int[] mergeArray  = new int[len1 + len2];
        for(int i=0;i<len1+len2;i++){

            if(index1 >= len1 ){
                mergeArray[i] = nums2[index2];
                index2++;
                continue;
            }

            if(index2>= len2 ){
                mergeArray[i] = nums1[index1];
                index1++;
                continue;
            }
            if( nums1[index1]>nums2[index2]){
                mergeArray[i] = nums2[index2];
                index2++;
            }else if(nums1[index1]<=nums2[index2]){
                mergeArray[i] = nums1[index1];
                index1++;
            }
        }
        return getMid(mergeArray);
    }

    public static double getMid(int[] nums){
        if(nums.length%2==0){
            return (nums[nums.length/2] + nums[nums.length/2 - 1])/2.0;
        } else {
            return nums[(nums.length-1)/2];
        }

    }
}
