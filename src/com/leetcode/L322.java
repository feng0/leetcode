package com.leetcode;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L322 {
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int res = coinChange(coins,11);
        System.out.println(res);

        int[] newCoins = {2};
        res = coinChange(newCoins,3);
        System.out.println(res);
    }
    /**
     * def coinChange(coins: List[int], amount: int):
     *     # 备忘录
     *     memo = dict()
     *     def dp(n):
     *         # 查备忘录，避免重复计算
     *         if n in memo: return memo[n]
     *         # base case
     *         if n == 0: return 0
     *         if n < 0: return -1
     *         res = float('INF')
     *         for coin in coins:
     *             subproblem = dp(n - coin)
     *             if subproblem == -1: continue
     *             res = min(res, 1 + subproblem)
     *
     *         # 记入备忘录
     *         memo[n] = res if res != float('INF') else -1
     *         return memo[n]
     *
     *     return dp(amount)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dict = new int[amount+1];
        Arrays.fill(dict,amount+1);

        dict[0]=0;
        for(int i=0;i<amount +1 ;i++){
            for(int coin:coins){
                if(i-coin<0){
                    continue;
                }
                dict[i] = Math.min(dict[i-coin] + 1,dict[i]);
            }

        }

        return dict[amount]==amount+1?-1:dict[amount];
    }
}
