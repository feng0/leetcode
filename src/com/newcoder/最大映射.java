package com.newcoder;

import java.util.Scanner;

public class 最大映射 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String line;
        int lineNum = 0;
        String[] arr = null;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            if("".equals(line)){
                break;
            }
            lineNum++;
            if(lineNum == 1){
                arr = new String[Integer.parseInt(line)];
            }
            arr[lineNum-2] = line;


            System.out.println(findDigit(arr));
        }



    }

    public static int findDigit(String[] arr){
        //0 1 2 3 4 5 6 7 8 9
        //A B C D E F G H I J
        int[] dgt = new int[10];
        for(String a:arr){
            for(int i=0;i<a.length();i++){
                dgt[a.charAt(i)-'A'] += 9 - i;
            }
        }

        return 0;
    }
}
