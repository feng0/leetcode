package com.newcoder;

import java.util.Scanner;

public class 景区调度 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        int[] digits = new int[Integer.parseInt(firstLine)];
        String[] digitStrs = secondLine.split(" ");

        //错误标志位
        boolean error = false;
        for(int i=0;i<digitStrs.length;i++){
            digits[i] = Integer.parseInt(digitStrs[i]);
            if(digits[i] < 0 || digits[i] > 20){
                error = true;
            }
        }

        if(error){
            error();
        }else{
            System.out.println(getMax(digits));
        }

    }

    /**
     * 计算最大数值
     * @param digits
     * @return
     */
    public static int getMax(int[] digits){
        int[][] table = new int[digits.length][2];
        table[0][0] = 0;
        table[0][1] = digits[0];
        for(int i=1;i<digits.length;i++){
            table[i][0] = Math.max(table[i-1][0] , table[i-1][1]);
            table[i][1] = table[i-1][0] + digits[i];
        }

        return Math.max(table[digits.length-1][0],table[digits.length-1][1]);
    }

    public static void error(){
        System.out.println("ERROR");
    }
}
