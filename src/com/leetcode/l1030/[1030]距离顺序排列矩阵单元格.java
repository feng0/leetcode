//给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。 
//
// 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。 
//
// 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈
//顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。） 
//
// 
//
// 示例 1： 
//
// 输入：R = 1, C = 2, r0 = 0, c0 = 0
//输出：[[0,0],[0,1]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
// 
//
// 示例 2： 
//
// 输入：R = 2, C = 2, r0 = 0, c0 = 1
//输出：[[0,1],[0,0],[1,1],[1,0]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
//[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
// 
//
// 示例 3： 
//
// 输入：R = 2, C = 3, r0 = 1, c0 = 2
//输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
//其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= R <= 100 
// 1 <= C <= 100 
// 0 <= r0 < R 
// 0 <= c0 < C 
// 
// Related Topics 排序 
// 👍 60 👎 0
package com.leetcode.l1030;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0,R-r0-1) + Math.max(c0,C-c0-1);
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=maxDist;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int d = Math.abs(i-r0) +Math.abs(j-c0);
                list.get(d).add(new int[]{i,j});
            }
        }
        int[][] res = new int[R*C][2];
        int index = 0;
        for(int i=0;i<=maxDist;i++){
            for(int[] it :list.get(i)){
                res[index++] = it;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int R = 2, C = 3, r0 = 1, c0 = 2;
        int[][] res = solution.allCellsDistOrder(R,C,r0,c0);
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
