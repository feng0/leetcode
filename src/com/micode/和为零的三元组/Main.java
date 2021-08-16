package com.micode.和为零的三元组;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            if("".equals(line)){
                break;
            }
            String[] arr = line.split(",");
            process(convert(arr),0,new int[3],0);
             System.out.println(set.size());
        }
    }

    public static int[] convert(String[] arr){
        int[] a = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            a[i] = Integer.parseInt(arr[i]);
        }

        return a;
    }


    public static void process(int[] arr,int a_index,int[] res,int r_index){
        int r_count = r_index + 1;
        if(r_count > 3){
//            System.out.println(Arrays.toString(res) + " 和为:" + (res[0] + res[1] + res[2]));
            if(res[0] + res[1] + res[2] == 0){
                Arrays.sort(res);
                set.add(res[0] + "," + res[1] +","+res[2]);
            }

            return;
        }
        System.out.println("a_index: "+ a_index +", for end"+(arr.length - res.length+r_count));
        for(int i=a_index;i<arr.length ;i++){
            res[r_index] = arr[i];
            process(arr,i+1,res,r_index + 1);
        }
    }
}
