package com.leetcode;

/**
 * 斐波那契数列
 */
public class L509 {

    public static void main(String[] args) {
	// write your code here
        System.out.println(fib3(2));
        System.out.println(fib3(3));
        System.out.println(fib3(4));
    }

    public static int fib(int N) {
        if(N < 2){
            return N;
        }
        return fib(N-1)+fib(N-2);
    }

    public static int fib2(int N){
        if(N < 2){
            return N;
        }
        int[] temp = new int[N+1];
        return helper(temp,N);
    }

    public static int helper(int[] temp,int N){
        if(N < 2){
            return N;
        }
        if(temp[N] != 0 ){
            return temp[N];
        }
        temp[N] = helper(temp,N-1) +helper(temp,N-2);
        return temp[N];
    }

    public static int fib3(int N){
        if(N < 2){
            return N;
        }
        int[] temp = new int[N+1];
        temp[0]=0;temp[1]=1;
        for(int i=2;i<N+1;i++){
            temp[i] = temp[i-1]+temp[i-2];
        }
        return temp[N];
    }
}
