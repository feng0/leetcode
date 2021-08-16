//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 844 👎 0
package com.leetcode.l283;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        while(true){
            int zero = nums.length-1;
            int noZero = 0;
            int zeroTime = 0;
            int noZeroTime = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 0 && zeroTime == 0){
                    zero = i;
                    zeroTime ++;
                }else if(nums[i] != 0 && i>zero){
                    noZero = i;
                    noZeroTime++;
                }
                if(zeroTime == 1 && noZeroTime == 1){
                    swap(zero,noZero,nums);
                    break;
                }
            }
            if(noZero == 0){
                break;
            }
        }

    }

    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
