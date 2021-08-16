package com.leetcode.l233数字1的个数;


public class Solution {
    public int countDigitOne(int n) {
        int left = 0,right = 0;
        for(int i=1;i<n+1;i++){
            int cnt = getOneNum(i);
            left = right;
            right = left + cnt;
        }
        return right;
    }

    public int getOneNum(int m){
        String s = String.valueOf(m);
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        Solution solution = new Solution();

        int[] arr = {346};
        for(int i=0;i<arr.length;i++){
            int res =solution.countDigitOne2(arr[i]);
            System.out.println("i=" + arr[i] + ", res: "+ res);
        }

    }

    public int countDigitOne2(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }






}
