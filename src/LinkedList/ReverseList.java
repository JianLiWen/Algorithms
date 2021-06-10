package LinkedList;

/**
 * @Description:反转链表
 * @Author: wenjianli
 * @Date: 2021/6/7 20:50
 * @date 2021-06-07 20:51
 * @author wenjianli3
 */
/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

输入：head = [1,2]
输出：[2,1]
 {}
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode node  = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode reverseNode = reverseList(node);
        while (reverseNode!=null){
            System.out.print(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
