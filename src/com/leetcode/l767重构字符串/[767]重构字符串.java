//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 192 👎 0
package com.leetcode.l767重构字符串;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        int maxCont = 0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            counts[c-'a'] ++;
        }
        for(int i = 0;i<counts.length;i++){
            maxCont = Math.max(maxCont,counts[i]);
        }

        if(maxCont > ((S.length()+1) >>1)){
            return "";
        }

        char[] reorganizeArray = new char[S.length()];
        int evenIndex = 0,oddIndex = 1;
        for(int i=0;i<26;i++){
            char c = (char)('a' + i);
            while(counts[i]>0 && counts[i]<=(S.length()>>1) && oddIndex < S.length()){
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while(counts[i]>0 && evenIndex < S.length()){
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String S = "aab";
        String res = solution.reorganizeString(S);
//        System.out.println(res);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
