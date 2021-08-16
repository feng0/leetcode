package com.leetcode.l25k个一组翻转链表;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //设置空节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        //结束条件
        while(end.next!=null){
            //循环k个节点
            for(int i=0;i<k&&end!=null;i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            //把k个节点拿出,翻转k个节点
            pre.next = reverse(start);

            //已翻转和未翻转重连
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;


    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    /**Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



