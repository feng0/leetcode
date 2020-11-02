package com.micode.大数相减;

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
            String[] arrs = line.split("-");
            // System.out.println("answer");
            list.add(findDigit(arrs));
        }

        for(String a:list){
            System.out.println(a);
        }
    }

    public static String findDigit(String[] arrs){
        String a = arrs[0];
        String b = arrs[1];
        int m =0 ,n = 0, c=0;
        StringBuffer res = new StringBuffer();
        for(int i=a.length()-1;i>=0;i--){
            m = a.charAt(i)-'0';
            int bIndex = i+b.length()-a.length();
            if(bIndex >= 0){
                n = b.charAt(bIndex)-'0';
            }else{
                n = 0;
            }

            res.append((m-n-c + 10)%10);
            if(m-n-c>=0){
                c=0;
            }else{
                c=1;
            }

        }
        res.reverse();
        return res.toString();
    }
}
