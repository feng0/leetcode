package com.micode.移除K位得到最小值;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    static List<Long> res = new ArrayList<>();
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if("".equals(line)){
                break;
            }
            String[] arr = line.split(" ");
            long r = calculate(arr[0],Integer.parseInt(arr[1]));
            res.add(r);
        }

        for(long i:res){
            System.out.println(i);
        }
    }

    public static long calculate(String s,int k){
        int len = s.length();
        int[] a = new int[len];
        for(int i=0;i<a.length;i++){
            a[i] = i;
        }
        combination(a,0,new int[k],0,s);
        long min = Long.MAX_VALUE;
        for(long i:list){
            min = Math.min(min,i);
        }
        return min;
    }

    public static void combination(int[] a,int a_index,int [] result,int r_index,String s){
        int r_len = result.length;
        int r_count = r_index +1;
        if(r_count>r_len){
            //输出
            String digit = leftDigit(s,result);
            list.add(Long.parseLong(digit));
            return;
        }

        for(int j=a_index;j<a.length+r_count-r_len;j++){
            result[r_index] = a[j];
            combination(a,j+1,result,r_index+1,s);
        }
    }

    public static String leftDigit(String s,int[] a){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
