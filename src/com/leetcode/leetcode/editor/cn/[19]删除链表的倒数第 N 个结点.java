//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1340 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package com.leetcode.leetcode.editor.cn;

class Solution2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode tail = head;
//
//        for(int i=2;i<6;i++){
//            ListNode temp = new ListNode(i);
//            tail.next = temp;
//            tail = tail.next;
//        }

        Solution2 solution = new Solution2();
        ListNode res = solution.removeNthFromEnd(head,1);
        System.out.println(res);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode dummy = new ListNode(0,head);
        ListNode second = dummy;
        int cnt = 0;
        //查找倒数第n个节点
        while(first.next != null){
            first = first.next;
            cnt++;
            if(cnt >= n){
                second = second.next;
            }
        }
        //此时second下一个为倒数第n个节点
        //删除
        if(second.next != null){
            second.next = second.next.next;
        }
        return dummy.next;
    }

    

      public static class ListNode {
          public int val;
          public ListNode next;
          public ListNode() {}
          public ListNode(int val) { this.val = val; }
          public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
//leetcode submit region end(Prohibit modification and deletion)
