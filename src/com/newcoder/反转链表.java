package com.newcoder;

import java.util.ArrayList;
import java.util.List;

public class 反转链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = listNode;
        while(node!=null){
            list.add(0,node.val);
            node = node.next;
        }

        return list;
    }


         public class ListNode {
             int val;
             ListNode next = null;

             ListNode(int val) {
                 this.val = val;
            }
        }

}
