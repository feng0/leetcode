package com.leetcode.offer32从上到下打印二叉树;

import com.leetcode.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        if(root != null){
            stack.add(root);
        }
        while(!stack.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<stack.size();i++){
                TreeNode node = stack.poll();
                temp.add(node.val);
                if(node.left!=null){
                    stack.add(node.left);
                }
                if(node.right!=null){
                    stack.add(node.right);
                }
            }
            res.add(temp);
        }

        return res;
    }

    public static void  main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        for(int i=0;i<queue.size();i++){
            System.out.println("-----"+queue.poll());
        }

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(1);
        queue2.add(2);
        queue2.add(3);
        for(int i=queue2.size();i>0;i--){
            System.out.println(""+queue2.poll()+"-----------");
        }
    }
}
