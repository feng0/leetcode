package com.micode.进制转换;

import java.util.ArrayList;
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
            String[] arrs = line.split(" ");
            String res = findDigit(arrs[0],Integer.parseInt(arrs[1]),Integer.parseInt(arrs[2]));
            list.add(res);
        }

        for(String a:list){
            System.out.println(a);
        }
    }

    public static String findDigit(String a,int m,int n){
        int ten = 0;
        if(m != 10){
            //转10进制
            ten = convert10(a,m);
            if(n == 10 ){
                //返回
                return String.valueOf(ten);
            }
        }else{
            ten = Integer.parseInt(a);
        }

        //转n进制
        String res = convertn(ten,n);

        return res;
    }

    public static int convert10(String a,int m ){
        int res = 0;
        for(int i=0;i<a.length();i++){
            if((a.charAt(i)-'0') >= 10){
                res += (a.charAt(i)-'a' + 10) * Math.pow(m , (a.length()-1 - i)) ;
            }else{
                res += (a.charAt(i)-'0') * Math.pow(m , (a.length()-1 - i)) ;
            }

        }
        return res;
    }

    public static String convertn(long a ,int n){
        String str = "";
        long yushu;
        long shang = a;
        while (shang > 0){
            yushu = shang % n;
            shang = shang / n;
            if(yushu > 9){
                str = (char)('a' + (yushu-10)) + str;
            }else{
                str = yushu + str;
            }
        }
        return str;
    }
}
