package com.leetcode.l122买卖股票的最佳时机II;

public class Solution {
    public int maxProfit1(int[] prices){

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            max = Math.max(dp[i][0],dp[i][1]);
        }

        return max;
    }

    public int maxProfit(int[] prices){

        int pre0 = 0;
        int pre1 = -prices[0];
        int max = 0;

        for(int i=1;i<prices.length;i++){
            int current0 = Math.max(pre0,pre1+prices[i]);
            int current1 = Math.max(pre0-prices[i],pre1);
            max = Math.max(current0,current1);
            pre0 = current0;
            pre1 = current1;
        }

        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        int res = solution.maxProfit(prices);
        System.out.println(res);
    }
}
