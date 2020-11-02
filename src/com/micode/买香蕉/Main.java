package com.micode.买香蕉;

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
        int[] arrDigit = new int[arrs.length];
        for(int i=0;i<arrs.length;i++){
            arrDigit[i] = Integer.parseInt(arrs[i]);
        }
        Arrays.sort(arrDigit);
        int max = arrDigit[arrDigit.length-1];
        for(int i=0;i<arrDigit.length;i++){
            if(arrDigit[i]>0){
                int ji = arrDigit[i] * (arrDigit.length-i);
                max = max > ji ?max:ji;
            }

        }

        return max;
    }
}
