package com.micode.交叉队列;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        List<Boolean> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            if("".equals(line)){
                break;
            }
            String[] arr = line.split(",");
            list.add(judge(arr[0],arr[1],arr[2]));
            // System.out.println("answer");
        }

        for(boolean a : list){
            System.out.println(a);
        }
    }

    public static boolean judge(String a,String b,String c){
        int len1 = a.length();
        int len2 = b.length();
        int len3 = c.length();

        if(len1+len2!=len3){
            return false;
        }
        int i=0,j=0,k=0;
        while((i + j) < len3){
            if(i < len2 && b.charAt(i) == c.charAt(k)) {
                i++;
                k++;
            }else if(j < len1 && a.charAt(j) == c.charAt(k)){
                j++;
                k++;
            }else{
                break;
            }
        }
        if(i+j != len3){
            return false ;
        }
        // 返回处理后的结果
        return true ;
    }



}
