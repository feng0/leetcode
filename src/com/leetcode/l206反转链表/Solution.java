package com.leetcode.l206反转链表;

import com.leetcode.ListNode;

import java.math.BigDecimal;
import java.util.Random;

public class Solution {
    public ListNode reverseList(ListNode head) {
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

    private static Random random = new Random();
    public static void main(String[] args){
        int[] res = getMoney(100,5);
        for(int a:res){
            System.out.println(a);
        }
    }


    public static int[] getMoney(int total, int personNum){
        int[] res = new int[personNum];
        int sum = 0;

        for(int i=0;i<personNum-2;i++){
            res[i] = getRandom(total,sum);
            sum = sum + res[i];
        }

        int temp = getRandom(total,sum);
        while(sum < total * 0.4){
            temp = getRandom(total,sum);
        }
        res[personNum -2] = temp;

        res[personNum - 1] = total - sum - temp ;
        return res;

    }
    public static int getRandom(int total,int sum){
        int number = 0;
        int temp = 0;
        do{
            number = random.nextInt(total);
            temp =  sum + number;
        }while (number > 0.6 * total || temp > total);
        return number;
    }

}
