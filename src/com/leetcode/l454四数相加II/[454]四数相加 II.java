//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 哈希表 二分查找 
// 👍 239 👎 0
package com.leetcode.l454四数相加II;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map1 = getSumStat(A,B);
        Map<Integer,Integer> map2 = getSumStat(C,D);
        int cnt = 0;
        for(Map.Entry<Integer,Integer> entry:map1.entrySet()){
            if(map2.containsKey(0-entry.getKey())){
                cnt = cnt + entry.getValue() * map2.get(0-entry.getKey());
            }
        }
        return cnt;
    }

    public Map<Integer,Integer> getSumStat(int[] A,int[] B){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int sum = A[i] + B[j];
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum) + 1);
                }else{
                    map.put(sum,1);
                }
            }
        }

        return map;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] A = {-1,1,1,1,-1};
        int[] B = {0,-1,-1,0,1};
        int[] C = {-1,-1,1,-1,-1};
        int[] D = {0,1,0,-1,-1};
        int res = solution.fourSumCount(A,B,C,D);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
