package com.micode.不一样的排序;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if("".equals(line)){
                break;
            }
            // please write your code here
            String[] arrs = line.split(" ");
            System.out.println(findDigit(arrs));

        }

    }

    public static int findDigit(String[] arrs){
        int k = Integer.parseInt(arrs[0]);
        int[] arr = new int[Integer.parseInt(arrs[1])];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=2;i<arrs.length;i++){
            arr[i-2] = Integer.parseInt(arrs[i]);
            int cnt = parseDigit(arr[i-2]);
            map.put(arr[i-2],cnt);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() > o2.getValue()){
                    return 1;
                }else if(o1.getValue() < o2.getValue()){
                    return -1;
                }else{
                    return 0;
                }

            }
        });

        return list.get(k-1).getKey();

    }

    public static int parseDigit(int num) {
        if(num == 1){
            return 1;
        }
        int cnt = 0;
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i == 0){
                cnt += 2;
            }
        }

        return cnt;
    }
}
