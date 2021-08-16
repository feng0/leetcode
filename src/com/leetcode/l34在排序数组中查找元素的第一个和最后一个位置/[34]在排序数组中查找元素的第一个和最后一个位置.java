//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 691 👎 0
package com.leetcode.l34在排序数组中查找元素的第一个和最后一个位置;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public static void main(String[] args){
        int[] nums = {2,2};
        int target = 1;
        Solution solution = new Solution();
        int[] res = solution.searchRange(nums,target);
        System.out.println(Arrays.toString(res));
    }*/
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            int[] arr = {-1,-1};
            return arr;
        }
        List<Integer> res = new ArrayList<>();
        search(0,nums.length,nums,target,res);
        if(res.size() == 0){
            int[] arr = {-1,-1};
            return arr;
        }
        int min = nums.length,max =0;
        for(int i=0;i<res.size();i++){
            min = Math.min(min,res.get(i));
            max = Math.max(max,res.get(i));
        }
        int[] arr = {min,max};
        return arr;
    }

    public void search(int left,int right,int[] nums,int target,List<Integer> res){

        int mid = (left + right)/2;
        if(left > right || mid >= nums.length){
            return;
        }
        if(nums[mid] > target){
            right = mid -1;
            search(left,right,nums,target,res);
        } else if (nums[mid] < target){
            left = mid + 1;
            search(left,right,nums,target,res);
        } else if (nums[mid] == target){
            res.add(mid);
            int min = mid-1;
            while(min>=0){
                if(nums[min] == target){
                    res.add(min);
                }
                min--;
            }
            int max = mid+1;
            while(max<nums.length){
                if(nums[max] == target){
                    res.add(max);
                }
                max++;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
