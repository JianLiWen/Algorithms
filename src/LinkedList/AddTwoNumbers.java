package LinkedList;

import java.awt.*;
import java.awt.peer.LightweightPeer;
/**
 * @Description:两数相加
 * @Author: wenjianli
 * @Date: 2021/5/17 20:25
 */

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
 */
class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        System.out.println(l1);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        ListNode node = addTwoNumbers(l1,l2);
        while (node !=null){
            System.out.print(node.val);
            node = node.next;
        }

    }

    // 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 000，比如 987 + 23 = 987 + 023 = 1010
    //每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
    //如果两个链表全部遍历完毕后，进位值为 111，则在新链表最前方添加节点 111
    //小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head = new ListNode(0);
         ListNode cur = head;
         int curry = 0;
         while (l1!=null || l2!=null){
             int x = l1 == null? 0: l1.val;
             int y = l2 == null? 0: l2.val;
             int sum = x+y+curry;

             curry = sum/10;
             sum = sum % 10;
             cur.next = new ListNode(sum);
             cur = cur.next;

             if (l1 !=null){
                 l1 = l1.next;
             }

             if (l2 != null){
                 l2 = l2.next;
             }
         }
         if (curry !=0){
             cur.next = new ListNode(curry);
         }
         return head.next;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

