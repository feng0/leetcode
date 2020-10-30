package com.leetcode.l129求根到叶子节点数字之和;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int sumNumbers(TreeNode root) {

        return dfs(root,0);

    }

    public static int dfs(TreeNode root,int preSum){
        if(root == null ){
            return 0;
        }
        preSum =  preSum*10 + root.val;
        if(root.left == null && root.right == null){
           return preSum;
        }else{
            return dfs(root.left,preSum) + dfs(root.right,preSum);
        }


    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left= new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        int res = sumNumbers(root);
        System.out.println(res);
    }

}
