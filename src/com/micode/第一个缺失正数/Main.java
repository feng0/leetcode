package com.micode.第一个缺失正数;
import java.util.*;

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
            String[] arr = line.split(",");
            list.add(find(arr));
        }

        for(int a : list){
            System.out.println(a);
        }
    }

    public static int find(String[] arr){
        boolean[] res = new boolean[arr.length+1];
        for(int i=0;i<arr.length;i++){
            int temp = Integer.parseInt(arr[i]);
            if(temp>0){
                res[temp-1]=true;
            }
        }
        for(int j=0;j<res.length;j++){
            if(!res[j]){
                return j+1;
            }
        }
        return 0;
    }
}
