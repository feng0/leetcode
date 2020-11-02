package com.micode.找出单独出现的数字;

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
        Arrays.sort(arrs);

        for(int i=0;i<arrs.length;i++){
            //int num = Integer.parseInt(arrs[i]);
            if(!arrs[0].equals(arrs[1])  && !arrs[0].equals(arrs[2])){
                return Integer.parseInt(arrs[0]);
            }
            if(!arrs[arrs.length-1].equals(arrs[arrs.length-2]) && !arrs[arrs.length-1].equals(arrs[arrs.length-3])){
                return Integer.parseInt(arrs[arrs.length-1]);
            }
            if(i>0 && !arrs[i].equals(arrs[i-1]) && !arrs[i].equals(arrs[i+1])){
                return Integer.parseInt(arrs[i]);
            }
        }

        return 0;
    }
}
