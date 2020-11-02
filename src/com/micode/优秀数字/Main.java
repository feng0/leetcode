package com.micode.优秀数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        List<String> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if("".equals(line)){
                break;
            }
            // please write your code here

            // System.out.println("answer");
            list.add(getResult(Long.parseLong(line)));
        }

        for(String a:list){
            System.out.println(a);
        }
    }

    public static String getResult(long i){
        long n = 0;
        int flag1 = 0;
        int flag2 = 0;
        while(true){
            long m = (n==0?1:2L<<(n-1)) + 1L;
            long mm = (n==0?1:2L<<(n-1)) -1L;
            if(m == i){
                flag1 = 1;
            }
            if(mm == i){
                flag2 = 1;
            }
            n++;
            if(mm > i){
                break;
            }
        }
        if(flag1 + flag2 == 2){
            return "Very Good";
        }else if (flag1 == 1){
            return "Good";
        }else if(flag2 == 1){
            return "Bad";
        }else {
            return "Normal";
        }
    }
}
