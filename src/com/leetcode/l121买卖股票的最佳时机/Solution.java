package com.leetcode.l121买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices){
        //最多只能买一次，卖一次，所以最大收益是 求最大差值（前小后大）
        int n = prices.length;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = prices[j] - prices[i];
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices){
        //最多只能买一次，卖一次，所以最大收益是 求最大差值（前小后大）
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<n;i++){
            if(min>prices[i]){
                min = prices[i];
            }else {
                int temp = prices[i]-min;
                max = temp>max?temp:max;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {7,1,5,3,6,4};
        int res = solution.maxProfit2(arr);
        System.out.println(res);
    }
}
