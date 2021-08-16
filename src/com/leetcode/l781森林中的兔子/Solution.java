package com.leetcode.l781森林中的兔子;

import com.leetcode.l129求根到叶子节点数字之和.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {0,0,1,1,1};
        int res = solution.numRabbits(arr);
        System.out.println(res);
    }
    public int numRabbits(int[] answers){
        int res = 0;
        int[] answers_count = new int[1000];

        if(answers.length == 0){
            return 0;
        }

        for(int i=0;i<answers.length;i++){
            if(answers_count[answers[i]] == 0){
                res += (answers[i] + 1);
                answers_count[answers[i]] = answers[i];
            }else{
                answers_count[answers[i]]--;
            }
        }

        return res;
    }

    public List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }

    public List<Integer> postorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null ){
            return res;
        }
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
