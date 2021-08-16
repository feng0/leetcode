package com.micode.找出可能的合的组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        List<Integer> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if("".equals(line)){
                break;
            }
            // please write your code here
            String[] arrs = line.split(" ");
            // System.out.println("answer");
            list.add(findDigit(arrs));
        }

        for(int a:list){
            System.out.println(a);
        }
    }

    public static int findDigit(String[] arrs){
        String[] shuzu = arrs[0].split(",");
        int[] arrDigit = new int[shuzu.length-1];
        for(int i=0;i<shuzu.length-1;i++){
            arrDigit[i] = Integer.parseInt(shuzu[i]);
        }
        int target = Integer.parseInt(arrs[1]);
        int[] dp = new int[target+1];
        Arrays.fill(dp,0);
        for(int i=0;i<dp.length;i++){

            for(int j=0;j<arrDigit.length;j++){
                if(i-arrDigit[j] < 0){
                    continue;
                }
                dp[i] += dp[i-arrDigit[j]] + 1;
            }
        }

        return dp[target];
    }

    public static int dfs(int n,int[] dp,int[] arr){
        if(dp[n] != -1){
            return dp[n];
        }
        for(int i=0;i<arr.length;i++){
            dp[n] = dp[n-arr[i]] + 1;
        }

        return 0;
    }
}
