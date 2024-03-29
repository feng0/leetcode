package com.leetcode.l1356根据数字二进制下1的数目排序;

import java.util.*;

public class Solution {
    public int[] sortByBits(int[] arr){
        Map<Integer,Integer> map = new HashMap<>(arr.length,1);
        Map<Integer, List<Integer>> valueMap = new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            int cnt = Integer.bitCount(arr[i]);;
            map.put(arr[i],cnt);
            if(valueMap.containsKey(cnt)){
                List<Integer> set = valueMap.get(map.get(arr[i]));
                set.add(arr[i]);
            }else{
                valueMap.put(cnt,new ArrayList<>(Arrays.asList(arr[i])));
            }
        }

        int j=0;
        for(Map.Entry<Integer,List<Integer>> entry:valueMap.entrySet()){
            int[] temp = entry.getValue().stream().mapToInt(i->i).toArray();
            Arrays.sort(temp);
            for(int s:temp){
                arr[j] = s;
                j++;
            }

        }
        return arr;
    }


    public static void main(String[] args){
        Solution solution = new Solution();

//        int[] arr = {1633,2181,7558,2650,1920,809,4903,2223,4271,4110,7564,5428,1730,5970,9640,3185,7564,5040,4344,9479,2070,6569,9849,73,2961,7991,9419,7946,3293,882,4714,3813,278,6121,9244,8248,5424,2377,4270,7656,1983,2928,2876,4746,129,5971,522,349,1239,9493,4777,1421,1763,8419,5696,726,6130,9164,5290,6793,3670,3090,3395,5597,7557,6246,956,7791,677,2284,7280,5309,8274,1760,2383,7003,4094,1681,8885,3010,1551,7419,813,9937,7054,9615,8126,2739,3255,334,587,634,3382,3316,4630,6077,4687,2226,8910,8357,1961,1454,6416,8838,6295,4523,9736,6165,2849,7877};
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] res = solution.sortByBits(arr);

        System.out.println(Arrays.toString(res));
    }
}
//[129,73,522,278,1920,2070,2181,3090,4110,5696,6416,8248,8274,9736,334,587,677,809,1633,1681,1730,1760,2226,2377,2849,4630,4746,5424,6165,8357,8838,9244,349,634,726,813,882,1421,1551,2284,2650,2928,2961,3010,3185,3395,4270,4344,4714,4777,5040,5290,5428,6246,6793,7280,8419,9479,9493,9640,956,1239,1454,1763,1961,2223,2383,2739,2876,3316,3382,3670,4271,4523,4687,4903,5970,6295,6569,7557,7558,7564,7564,7946,8885,8910,9164,9419,9937,3255,3293,3813,5309,5971,7054,7656,7877,9615,9849,5597,6121,6130,7003,1983,6077,7419,7791,7991,4094,8126]