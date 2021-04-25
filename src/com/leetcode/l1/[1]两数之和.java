//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9633 👎 0
package com.leetcode.l1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int minus = target - nums[i];
            if(map.containsKey(minus)){
                return new int[]{map.get(minus),i};
            }
            map.put(nums[i],i);

        }

        return new int[]{};
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = s.twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
