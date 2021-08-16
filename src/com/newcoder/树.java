package com.newcoder;

import java.util.*;

public class 树 {

        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            System.out.println("Hello World!");
            树 a = new 树();
            a.solution();
        }

        public void solution(){
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.right = new Node(5);
            root.right.right = new Node(4);

            Map<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            get(root,map);
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                System.out.println(entry.getValue());
            }

        }

        public void get(Node root, Map<Integer,Integer> map){
            Node temp = root;
            if(temp != null ){
                map.put(getTreeDept(root),root.val);
                get(temp.left,map);
                get(temp.right,map);
            }
            return ;

        }
        public int getTreeDept(Node root){
            if(root == null || root.val==0){
                return 0;
            }

            return 1+Math.max(getTreeDept(root.left),getTreeDept(root.right));

        }
        public class Node {
            int val;
            Node left = null;
            Node right = null;

            Node(int val) {
                this.val = val;
            }
        }


}
