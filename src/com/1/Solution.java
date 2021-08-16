public class Solution {

    // 暴力匹配（伪码）
    int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (pat.charAt(j) != txt.charAt(i + j))
                    break;
            }
            // pat 全都匹配了
            if (j == M) return i;
        }
        // txt 中不存在 pat 子串
        return -1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String pat = "aaab";
        String txt = "aaacaaabcd" ;
        int res = solution.search(pat,txt);
        System.out.println(res);
    }
}
