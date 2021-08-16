package com.leetcode.l2两树相加;

import java.util.List;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = null;

        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            int l = l1==null?0:l1.val;
            int r = l2==null?0:l2.val;
            sum = carry + l + r;

            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null ){
                l2 = l2.next;
            }

        }
        if(carry != 0){
            tail.next = new ListNode(carry);
        }

        return head;
    }

    

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
