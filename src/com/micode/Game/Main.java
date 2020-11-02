package com.micode.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        List<String> list = new ArrayList<>();
        int totalCnt = 0;
        int flag = 0;
        while (scan.hasNextLine()) {
            totalCnt ++;
            line = scan.nextLine().trim();
            if(totalCnt == 1){
                flag = Integer.parseInt(line);
            }
            if(totalCnt > 1){
                String[] arrs = line.split(" ");
                list.add(findDigit(Integer.parseInt(arrs[1])));
            }
            if(totalCnt == flag + 1){
                break;
            }
        }

        for(String a:list){
            System.out.println(a);
        }
    }

    public static String findDigit(int n){


        return String.format("%.2f",0.50 * n);
    }
}
