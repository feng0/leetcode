package com.算法第4版.第一章基础;


public class Main1 {
    public static void main(String[] args) {
        int p = 12,q = 81;
        int res =  gcd(p,q);
        System.out.println(res);
    }

    /**
     * 计算两个非负整数p，q的最大公约数
     */
    public static int gcd(int p,int q){
        if(q==0) return p;
        int r = p % q;
        return gcd(q,r);
    }
}
