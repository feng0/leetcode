//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 195 👎 0
package com.leetcode.l633平方数之和;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.judgeSquareSum(2);
        System.out.println(res);
    }

    /**
     * 双指针 二分查找
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);

        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left ++;
            } else if (sum > c){
                right--;
            }
        }

        return false;
    }

    /**
     * 超时
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        set.add(1);
        int mid = c / 2;
        init(mid);

        for (int i = 0; i <= mid; i++) {
            int left = c - i * i;
            if (set.contains(left)) {
                return true;
            }
        }

        return false;
    }

    private void init(int n) {
        for (int i = 0; i <= n; i++) {
            int v = i * i;
            set.add(v);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
