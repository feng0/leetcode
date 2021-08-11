//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2734 👎 0
package com.leetcode.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int reverse(int x) {
        int pop = 0;
        int res = 0;
        while (x != 0) {
            if(res * 10 /10 != res){
                return 0;
            }
            pop = x % 10;
            x = x/10;
            res = res * 10 + pop;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        int res = solution2.reverse(1534236469);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
